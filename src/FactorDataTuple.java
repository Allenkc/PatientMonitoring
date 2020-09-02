import java.util.ArrayList;
import java.util.List;

public class FactorDataTuple {

    private Patient patient;
    private Sensor sensor;
    private List<Record> records = new ArrayList<>();

    public FactorDataTuple() {
    }

    public FactorDataTuple(Patient patient, Sensor sensor, List<Record> records) {
        this.patient = patient;
        this.sensor = sensor;
        this.records = records;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecord(long timeCheckPoint , double factorValue){
        this.records.add(new Record(timeCheckPoint , factorValue));
    }
}
