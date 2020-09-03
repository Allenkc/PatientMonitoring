/**
 *  存取table實體
 */
public class FactorDataEntity {

    private String patientName;
    private String sensorTypeName;
    private String sensorName;
    private Record record;

    public FactorDataEntity() {
    }

    public FactorDataEntity(String patientName, String sensorTypeName, String sensorName, Record record) {
        this.patientName = patientName;
        this.sensorTypeName = sensorTypeName;
        this.sensorName = sensorName;
        this.record = record;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
