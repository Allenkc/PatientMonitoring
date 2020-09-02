import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FactorDatabase {

//    private List<FactorDataTuple> tuples;
    private Map<String , FactorDataTuple> tuples = new LinkedHashMap<>();

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

    public void saveTuple(String key , FactorDataTuple tuple){
        tuples.put(key , tuple);
    }
}
