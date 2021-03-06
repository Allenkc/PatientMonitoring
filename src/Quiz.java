import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private static final String patient = "patient";

    private static List<Patient> patientList = new ArrayList<>();

    private static List<Sensor> sensorList = new ArrayList<>();

    private static FactorDatabase factorDatabase = new FactorDatabase();

    public static void main(String[] args) throws Exception {

        if (null == args[0]) {
            throw new IllegalArgumentException();
        }

        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        long allTimePeriod;
        if (line.chars().allMatch(Character::isDigit)) {
            allTimePeriod = Long.parseLong(line);
        } else {
            System.out.println("Input file format is invalid!");
            return;
        }
        line = reader.readLine();

        while (line != null) {
            String[] row =
                    line.split("\\s+");
            if (isPatient(row[0])) {
                // add new patient
                patientList.add(new Patient(row[1], Long.parseLong(row[2]), new ArrayList<>()));
            } else if (null != SensorType.toSensorType(row[0])) {

                addSensor(row);

            } else {
                System.out.println("Input file format is invalid!");
                return;
            }

            line = reader.readLine();
        }

        // read dataset to mock sensor behavior
        for (Sensor sensor : sensorList) {
            sensor.readFactorValue();
        }

        /**
         * After you reach end-of-file in input file, system starts to monitor.
         * While system starts to monitor, the timestamp is 0.
         * System finish monitoring when the timestamp reach {monitor_period}.
         * All devices attached to patients start to measure the patients’vital factors at timestamp 0.
         *
         * You can use for-loop counter as millisecond timestamp.
         */
//        for (Patient tmp : patientList) {
//            System.out.println("Patient: " + tmp.getName() + ", period is " + tmp.getFrequency());
//        }
//
//        for (Sensor tmp : sensorList) {
//            System.out.println("Device name: " + tmp.getDeviceName() + ", File name is : " + tmp.getFactorDataSetFileName()
//                    + ", attached to " + tmp.getIsAttachedTo() + ", safe range :" + tmp.getSafeRangeLowerBound() + "~" + tmp.getSafeRangeUpperBound());
//        }

        // 開始倒數
        for (long index = 0; index <= allTimePeriod; index += 1) {

            for (Patient pt : patientList) {
                if (index % pt.getFrequency() == 0) {

                    // 病人的檢查周期到了
                    for (Sensor ptSensor : pt.getAttachedSensors()) {

                        // 檢查有沒有在安全範圍內
                        if (ptSensor.showValue() == -1) {
                            System.out.println("[" + index + "]" + " " + ptSensor.getDeviceName() + " falls");
                        } else if (ptSensor.showValue() < ptSensor.getSafeRangeLowerBound()
                                || ptSensor.showValue() > ptSensor.getSafeRangeUpperBound()) {
                            ptSensor.alarm(index, pt.getName(), ptSensor.getDeviceName(), ptSensor.showValue());
                        }

                        // 監控的當下去存DB
                        FactorDataEntity entity = new FactorDataEntity();
                        entity.setSensorTypeName(ptSensor.getSensorTypeName());
                        entity.setSensorName(ptSensor.getDeviceName());
                        entity.setPatientName(pt.getName());
                        Record updateRecord = new Record(index, ptSensor.showValue());
                        entity.setRecord(updateRecord);
                        factorDatabase.add(entity);
                        ptSensor.incrementCounter();
                    }

                }

            }

        }
        factorDatabase.printData();

    }

    // TODO 檢查Patient格式
    private static boolean isPatient(String rawStr) {

        return patient.equalsIgnoreCase(rawStr);
    }

    /**
     * TODO 檢查Sensor格式
     */
    private static void addSensor(String[] row) {

        SensorType sensorType = SensorType.values()[SensorType.toSensorType(row[0]).ordinal()];

        switch (sensorType) {
            case PULSESENSOR:
                if (!patientList.isEmpty()) {
                    int currentPateintIndex = patientList.size() - 1;
                    PulseSensor pss = new PulseSensor(row[1], row[2], Double.parseDouble(row[3]), Double.parseDouble(row[4]),
                            patientList.get(currentPateintIndex).getName(), SensorType.PULSESENSOR.getName());

                    // 把sensor 貼到 patient上
                    patientList.get(currentPateintIndex).getAttachedSensors().add(pss);

                    sensorList.add(pss);
                } else {
                    System.out.println("Device must be read after patient!");
                    return;
                }
                break;
            case BLOODPRESSURESENSOR:
                if (!patientList.isEmpty()) {
                    int currentPateintIndex = patientList.size() - 1;
                    BloodPressureSensor bps = new BloodPressureSensor(row[1], row[2], Double.parseDouble(row[3]), Double.parseDouble(row[4]),
                            patientList.get(currentPateintIndex).getName(), SensorType.BLOODPRESSURESENSOR.getName());

                    // 把sensor 貼到 patient上
                    patientList.get(currentPateintIndex).getAttachedSensors().add(bps);

                    sensorList.add(bps);
                } else {
                    System.out.println("Device must be read after patient!");
                    return;
                }
                break;
            case TEMPERATURE:
                if (!patientList.isEmpty()) {
                    int currentPateintIndex = patientList.size() - 1;
                    TemperatureSensor ts = new TemperatureSensor(row[1], row[2], Double.parseDouble(row[3]), Double.parseDouble(row[4]),
                            patientList.get(currentPateintIndex).getName(), SensorType.TEMPERATURE.getName());

                    // 把sensor 貼到 patient上
                    patientList.get(currentPateintIndex).getAttachedSensors().add(ts);

                    sensorList.add(ts);
                } else {
                    System.out.println("Device must be read after patient!");
                    return;
                }
                break;
        }
    }


}
