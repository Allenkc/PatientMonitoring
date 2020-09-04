import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PulseSensor extends AbstractSensor {

    public PulseSensor(String deviceName, String factorDataSetFileName, double safeRangeLowerBound, double safeRangeUpperBound, String isAttachedTo, String sensorType) {
        this.deviceName = deviceName;
        this.factorDataSetFileName = factorDataSetFileName;
        this.safeRangeLowerBound = safeRangeLowerBound;
        this.safeRangeUpperBound = safeRangeUpperBound;
        this.isAttachedTo = isAttachedTo;
        this.detectCounter = 0;
        this.sensorType = sensorType;
    }
}
