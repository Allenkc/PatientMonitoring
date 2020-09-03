import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 結構範例:
 * patient Mark  <--- 當Key
 *
 * BloodPressureSensor sensor1  <---- List<SensorData>
 * [0] 150.0
 * [600] 123.0
 * [1200] -1.0
 * [1800] 200.0
 * [2400] -1.0
 * [3000] -1.0
 * BloodPressureSensor sensor2
 * 以下略
 *
 * 一個病人有多組sensor & 其數值資料
 *
 */

public class FactorDatabase {

    //    private List<FactorDataTuple> tuples;
    private Map<String, FactorDataTuple> tuples = new LinkedHashMap<>();

    public FactorDatabase() {
    }

    public FactorDatabase(Map<String, FactorDataTuple> tuples) {
        this.tuples = tuples;
    }

    public Map<String, FactorDataTuple> getTuples() {
        return tuples;
    }

    public void setTuples(Map<String, FactorDataTuple> tuples) {
        this.tuples = tuples;
    }

    public void save(String key, Patient patient, List<SensorData> sensorDataList,
                     long timeCheckPoint, double factorValue) {

        //TODO 有KEY表示存在 要update
        if (tuples.containsKey(key)) {
//            tuples.get(key).addSensorData();
        } else {
//            tuples.put(key, new FactorDataTuple(patient, ));
        }

    }

    public void save(FactorDataEntity entity) {

        // 檢查病人資料是否存在? patient name 當key
        if (tuples.containsKey(entity.getPatientName())) {
            // TODO 存在 則update
            FactorDataTuple tmp = tuples.get(entity.getPatientName());
        } else {
            // TODO 不存在，建立新資料
            tuples.put(entity.getPatientName(), this.makeTuple(entity.getPatientName(), entity.getSensorTypeName(),
                    entity.getSensorName(), entity.getRecord().getTimeCheckPoint(), entity.getRecord().getFactorValue()));
        }

    }

    public FactorDataTuple makeTuple(String patientName, String sensorTypeName, String sensorName,
                                     long timeCheckPoint, double factorValue) {

        FactorDataTuple tuple = new FactorDataTuple();
        tuple.setPatientName(patientName);
        tuple.addSensorData(new SensorData(sensorTypeName, sensorName, timeCheckPoint, factorValue));

        return tuple;

    }

    public void printDate() {

        for (Map.Entry<String, FactorDataTuple> entry : tuples.entrySet()) {
            String key = entry.getKey();
            FactorDataTuple value = entry.getValue();
            // now work with key and value...
            printMessageInFormat(value);
        }
    }

    private void printMessageInFormat(FactorDataTuple tuple) {


    }

}
