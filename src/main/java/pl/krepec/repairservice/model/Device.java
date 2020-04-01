package pl.krepec.repairservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {

    private static Long COUNTER_DEVICE_OBJECTS;


    public Long deviceId;
    public String model;
    public String serialNumber;
    public String issue;
    public String description;

    public Device(Long deviceId, String model, String serialNumber, String issue, String description) {

        COUNTER_DEVICE_OBJECTS++;

        this.deviceId = deviceId;
        this.model = model;
        this.serialNumber = serialNumber;
        this.issue = issue;
        this.description = description;
    }

    public Device() {
    }
}

