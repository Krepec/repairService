package pl.krepec.repairservice.dto;

import lombok.*;
import pl.krepec.repairservice.common.Status;
import pl.krepec.repairservice.dao.domain.Customer;
import pl.krepec.repairservice.dao.domain.Device;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class RepairDTO {


    public Long repairId;
    public String repairNumber;
    public Status status;
    public String issue;
    public String description;
    public OffsetDateTime startDate;
    public OffsetDateTime endDate;
    public String repairResult;
    public CustomerDTO customer;
    public DeviceDTO device;

}

