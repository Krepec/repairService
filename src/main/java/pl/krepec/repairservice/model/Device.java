package pl.krepec.repairservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Device {

    public Long COUNTER_DEVICE_OBJECTS = 0L;

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

