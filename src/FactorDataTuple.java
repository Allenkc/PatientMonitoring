import java.util.ArrayList;
import java.util.List;

public class FactorDataTuple {

    private String patientName;

    private List<SensorData> sensorDataList;

    public FactorDataTuple() {
    }

    public FactorDataTuple(String patientName) {
        this.patientName = patientName;
        this.sensorDataList = new ArrayList<>();
    }

    public FactorDataTuple(String patientName, List<SensorData> sensorDataList) {
        this.patientName = patientName;
        this.sensorDataList = sensorDataList;
    }

    public FactorDataTuple(String patientName, String sensorTypeName, String sensorName,long timeCheckPoint, double factorValue) {
        this.patientName = patientName;
        this.sensorDataList = new ArrayList<>();
        SensorData sensorData = new SensorData();
        sensorData.setSensorTypeName(sensorTypeName);
        sensorData.setSensorName(sensorName);
        List<Record> records = new ArrayList<>();
        records.add(new Record(timeCheckPoint,factorValue));
        sensorData.setRecords(records);
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void addSensorData(SensorData sensorData){
        this.sensorDataList.add(sensorData);
    }

    public void updateSensorData(){

    }
}
