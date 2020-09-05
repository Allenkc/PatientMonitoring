import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 結構範例:
 * patient Mark  <--- 當Key
 * <p>
 * BloodPressureSensor sensor1  <---- List<SensorData>
 * [0] 150.0
 * [600] 123.0
 * [1200] -1.0
 * [1800] 200.0
 * [2400] -1.0
 * [3000] -1.0
 * BloodPressureSensor sensor2
 * 以下略
 * <p>
 * 一個病人有多組sensor & 其數值資料
 */

public class FactorDatabase {

    private Map<String, List<SensorData>> tuples;

    public FactorDatabase() {
        this.tuples = new LinkedHashMap<>();
    }

    public Map<String, List<SensorData>> getTuples() {
        return tuples;
    }


    public void add(FactorDataEntity entity) {

        if (tuples.containsKey(entity.getPatientName())) {

            // 病患已存在，確認要加sensorData 還是只要更新Record
            this.addSensorDataByPatientName(entity);

        } else {
            // 寫入全新資料
            List<SensorData> sensorDataList = new ArrayList<>();
            sensorDataList.add(this.makeSensorData(entity));
            tuples.put(entity.getPatientName(), sensorDataList);
        }

    }

    /**
     * 依據病患名(Key)增加關聯的SensorData
     */
    private void addSensorDataByPatientName(FactorDataEntity entity) {

        // 確認要新增SensorData還是 更新Record
        boolean isSensorDataExist = false;

        for (SensorData tmp : tuples.get(entity.getPatientName())) {
            if (tmp.getSensorName().equalsIgnoreCase(entity.getSensorName())) {
                //有找到sensor是要去更新Record
                isSensorDataExist = true;
                tmp.getRecords().add(entity.getRecord());
            }
        }

        if (!isSensorDataExist) {
            // 新增SensorData
            this.tuples.get(entity.getPatientName()).add(this.makeSensorData(entity));
        }

    }

    /**
     * 組出要去新增或是更新的 SensorData
     * @param entity
     * @return
     */
    private SensorData makeSensorData(FactorDataEntity entity) {

        SensorData updateData = new SensorData();
        updateData.setSensorTypeName(entity.getSensorTypeName());
        updateData.setSensorName(entity.getSensorName());
        List<Record> recordList = new ArrayList<>();
        recordList.add(entity.getRecord());
        updateData.setRecords(recordList);

        return updateData;

    }

    public void printData() {

        for (Map.Entry<String, List<SensorData>> entry : tuples.entrySet()) {
            String patientName = entry.getKey();
            System.out.println("patient " + patientName);

            List<SensorData> value = entry.getValue();
            for (SensorData tmpData : value) {
                System.out.println(tmpData.getSensorTypeName() + " " + tmpData.getSensorName());
                for (Record tmpRecord : tmpData.getRecords()) {
                    System.out.println("[" + tmpRecord.getTimeCheckPoint() + "]" + " " + tmpRecord.getFactorValue());
                }
            }
        }
    }

}
