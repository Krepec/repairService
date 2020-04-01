package pl.krepec.repairservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Device {

    private static Long COUNTER_DEVICE_OBJECTS;


    public Long deviceId;
    public String model;
    public String serialNumber;


    public Device(Long deviceId, String model, String serialNumber) {

        COUNTER_DEVICE_OBJECTS++;

        this.deviceId = deviceId;
        this.model = model;
        this.serialNumber = serialNumber;
    }

}

