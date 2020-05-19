package pl.krepec.repairservice.dto;

import lombok.*;
import pl.krepec.repairservice.common.Status;

@Data
@NoArgsConstructor
public class RepairDTO {


    public Long repairId;
    public Long customerId;
    public Long deviceId;
    public String repairNumber;
    public Status status;
    public String issue;
    public String description;

    public RepairDTO(Long repairId, Long customerId, Long deviceId, String repairNumber, Status status, String issue, String description) {


        this.repairId = repairId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.repairNumber = repairNumber;
        this.status = status;
        this.issue = issue;
        this.description = description;
    }

    public void setRepairNumber(String repairNumber) {
        this.repairNumber = repairNumber;
    }
}
