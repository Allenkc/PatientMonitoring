public class BloodPressureSensor implements Sensor {

    private String deviceName;
    private String factorDataSetFileName;
    private double safeRangeLowerBound;
    private double safeRangeUpperBound;
    private String isAttachedTo; //which patient

    public BloodPressureSensor() {
    }

    public BloodPressureSensor(String deviceName, String factorDataSetFileName, double safeRangeLowerBound, double safeRangeUpperBound, String isAttachedTo) {
        this.deviceName = deviceName;
        this.factorDataSetFileName = factorDataSetFileName;
        this.safeRangeLowerBound = safeRangeLowerBound;
        this.safeRangeUpperBound = safeRangeUpperBound;
        this.isAttachedTo = isAttachedTo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getFactorDataSetFileName() {
        return factorDataSetFileName;
    }

    public void setFactorDataSetFileName(String factorDataSetFileName) {
        this.factorDataSetFileName = factorDataSetFileName;
    }

    public double getSafeRangeLowerBound() {
        return safeRangeLowerBound;
    }

    public void setSafeRangeLowerBound(double safeRangeLowerBound) {
        this.safeRangeLowerBound = safeRangeLowerBound;
    }

    public double getSafeRangeUpperBound() {
        return safeRangeUpperBound;
    }

    public void setSafeRangeUpperBound(double safeRangeUpperBound) {
        this.safeRangeUpperBound = safeRangeUpperBound;
    }

    public String getIsAttachedTo() {
        return isAttachedTo;
    }

    public void setIsAttachedTo(String isAttachedTo) {
        this.isAttachedTo = isAttachedTo;
    }

    @Override
    public void alarm(String patientName, String deviceName, double factorValue) {
        System.out.print(patientName + " is in danger!" + " Cause: " + deviceName + " " + factorValue);
    }
}
