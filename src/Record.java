public class Record {

    private long timeCheckPoint;
    private double factorValue;

    public Record() {
    }

    public Record(long timeCheckPoint, double factorValue) {
        this.timeCheckPoint = timeCheckPoint;
        this.factorValue = factorValue;
    }

    public long getTimeCheckPoint() {
        return timeCheckPoint;
    }

    public void setTimeCheckPoint(long timeCheckPoint) {
        this.timeCheckPoint = timeCheckPoint;
    }

    public double getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(double factorValue) {
        this.factorValue = factorValue;
    }
}
