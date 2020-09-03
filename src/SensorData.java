import java.util.ArrayList;
import java.util.List;

public class SensorData {

    private String sensorTypeName;
    private String sensorName;
    private List<Record> records;

    public SensorData() {
    }

    public SensorData(String sensorTypeName, String sensorName) {
        this.sensorTypeName = sensorTypeName;
        this.sensorName = sensorName;
        this.records = new ArrayList<>();
    }

    public SensorData(String sensorTypeName, String sensorName, List<Record> records) {
        this.sensorTypeName = sensorTypeName;
        this.sensorName = sensorName;
        this.records = records;
    }

    public SensorData(String sensorTypeName, String sensorName, long timeCheckPoint, double factorValue) {
        this.sensorTypeName = sensorTypeName;
        this.sensorName = sensorName;
        this.records = new ArrayList<>();
        records.add(new Record(timeCheckPoint,factorValue));
    }

    public String getSensorTypeName() {
        return sensorTypeName;
    }

    public void setSensorTypeName(String sensorTypeName) {
        this.sensorTypeName = sensorTypeName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record) {
        this.records.add(record);
    }
}
