package pl.krepec.repairservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DeviceDTO {


    public Long deviceId;
    public String model;
    public String serialNumber;


    public DeviceDTO(Long deviceId, String model, String serialNumber) {


        this.deviceId = deviceId;
        this.model = model;
        this.serialNumber = serialNumber;
    }

}

