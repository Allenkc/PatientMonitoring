import java.util.ArrayList;
import java.util.List;

public class SensorData {

    private Sensor sensor;
    private List<Record> records;

    public SensorData() {
    }

    public SensorData(Sensor sensor){
        this.sensor = sensor;
        this.records = new ArrayList<>();
    }

    public SensorData(Sensor sensor, List<Record> records) {
        this.sensor = sensor;
        this.records = records;
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

    public void addRecord(Record record){
        this.records.add(record);
    }
}
