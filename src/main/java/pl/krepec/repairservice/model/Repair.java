package pl.krepec.repairservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krepec.repairservice.Status;

@Setter
@Getter
@NoArgsConstructor
public class Repair {

    private static Long COUNTER_REPAIR_OBJECTS;

    public Long repairId;
    public Long customerId;
    public Long deviceId;
    public Status status;
    public String issue;
    public String description;

    public Repair(Long repairId, Long customerId, Long deviceId, Status status, String issue, String description) {

        COUNTER_REPAIR_OBJECTS++;

        this.repairId = repairId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.status = status;
        this.issue = issue;
        this.description = description;
    }
}
