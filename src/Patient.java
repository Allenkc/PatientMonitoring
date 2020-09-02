import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String name;

    private Long frequency;

    private List<Sensor> attachedSensors;

    public Patient() {
    }

    public Patient(String name, Long frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public Patient(String name, Long frequency ,List<Sensor> sensorList ) {
        this.name = name;
        this.frequency = frequency;
        this.attachedSensors = sensorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public List<Sensor> getAttachedSensors() {
        return attachedSensors;
    }

    public void setAttachedSensors(List<Sensor> attachedSensors) {
        this.attachedSensors = attachedSensors;
    }
}
