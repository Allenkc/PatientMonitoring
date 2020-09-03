import java.util.ArrayList;
import java.util.List;

public class FactorDataTuple {

    private Patient patient;
//    private Sensor sensor;
//    private List<Record> records;
    private List<SensorData> sensorDataList;

    public FactorDataTuple() {
    }

    public FactorDataTuple(Patient patient) {
        this.patient = patient;
        this.sensorDataList = new ArrayList<>();
    }

    public FactorDataTuple(Patient patient, List<SensorData> sensorDataList) {
        this.patient = patient;
        this.sensorDataList = sensorDataList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void addSensorData(SensorData sensorData){
        this.sensorDataList.add(sensorData);
    }
}
