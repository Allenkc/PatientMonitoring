import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 最後記得把src拿掉打平
 */

public class Quiz {

    public static final String patient = "patient";

    public static long allTimePeriod;

    public static boolean readAfterPatient = false;

    public static List<Patient> patientList = new ArrayList<>();

    public static List<Sensor> sensorList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        if (null == args[0]) {
            throw new IllegalArgumentException();
        }

//        File file = new File(".");
        // List Files
//        for(String fileNames : file.list()) System.out.println(fileNames);

        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        if (line.chars().allMatch(Character::isDigit)) {
            allTimePeriod = Long.parseLong(line);
        } else {
            System.out.println("Input file format is invalid!");
            return;
        }
        line = reader.readLine();

        List<String> rowInput = new ArrayList<>();
        while (line != null) {
            String[] row =
                    line.split("\\s+");
            if (isPatient(row[0])) {
                patientList.add(new Patient(row[1], Long.parseLong(row[2])));
                readAfterPatient = true;
            } else if (null != SensorType.toSensorType(row[0])) {

                addSensor(row);

            } else {
                System.out.println("Input file format is invalid!");
                return;
            }

            line = reader.readLine();
        }

        /**
         * After you reach end-of-file in input file, system starts to monitor.
         * While system starts to monitor, the timestamp is 0.
         * System finish monitoring when the timestamp reach {monitor_period}.
         * All devices attached to patients start to measure the patients’vital factors at timestamp 0.
         *
         * You can use for-loop counter as millisecond timestamp.
         */
        for (Patient tmp : patientList) {
            System.out.println("Patient: " + tmp.getName() + ", period is " + tmp.getFrequency());
        }

        for (Sensor tmp : sensorList) {
            System.out.println("Device name: " + tmp.getDeviceName() + ", File name is : " + tmp.getFactorDataSetFileName() + ", attached to " + tmp.getIsAttachedTo());
        }


        // TODO 開始倒數 取得的millisecond 用timer??
        for (long index = 0; index <= allTimePeriod; index = +1) {


        }

    }

    // TODO 檢查Patient格式
    private static boolean isPatient(String rawStr) {

        return patient.equalsIgnoreCase(rawStr);
    }

    // TODO 檢查Sensor格式
    private static void addSensor(String[] row) {

        SensorType sensorType = SensorType.values()[SensorType.toSensorType(row[0]).ordinal()];

        switch (sensorType) {
            case PULSESENSOR:
                break;
            case BLOODPRESSURESENSOR:
                if (readAfterPatient && !patientList.isEmpty()) {
                    BloodPressureSensor bps = new BloodPressureSensor(row[1], row[2], Double.parseDouble(row[3]), Double.parseDouble(row[4]), patientList.get(patientList.size() - 1).getName());
                    sensorList.add(bps);
                }

                break;
            case TEMPERATURE:
                break;
        }
    }
}
