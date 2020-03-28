package pl.krepec.repairservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Device {

    public Long deviceId;
    public String model;
    public String serialNumber;
    public String issue;
    public String description;

}