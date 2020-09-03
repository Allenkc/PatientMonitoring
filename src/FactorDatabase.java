import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
            tuples.put(key,new FactorDataTuple(patient,sensorDataList));
        }

    }

    public void printDate(){

        for (Map.Entry<String, FactorDataTuple> entry : tuples.entrySet()) {
            String key = entry.getKey();
            FactorDataTuple value = entry.getValue();
            // now work with key and value...
            printMessageInFormat(value);
        }
    }

    private void printMessageInFormat(FactorDataTuple tuple){

        System.out.println("patient "+tuple.getPatient().getName());

    }

}
