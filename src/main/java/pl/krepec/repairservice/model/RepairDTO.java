package pl.krepec.repairservice.model;

import lombok.*;
import pl.krepec.repairservice.common.Status;

@Data
@NoArgsConstructor
public class RepairDTO {


    public Long repairId;
    public Long customerId;
    public Long deviceId;
    public Status status;
    public String issue;
    public String description;

    public RepairDTO(Long repairId, Long customerId, Long deviceId, Status status, String issue, String description) {


        this.repairId = repairId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.status = status;
        this.issue = issue;
        this.description = description;
    }
}
