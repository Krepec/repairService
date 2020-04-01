package pl.krepec.repairservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.temporal.ChronoUnit;

@Setter
@Getter
@NoArgsConstructor
public class Repair {

    private static Long COUNTER_REPAIR_OBJECTS;

    public Long repairId;
    public Long customerId;
    public Long deviceId;
    public String status;
    public String issue;
    public String description;

    public Repair(Long repairId, Long customerId, Long deviceId, String status, String issue, String description) {

        COUNTER_REPAIR_OBJECTS++;

        this.repairId = repairId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.status = status;
        this.issue = issue;
        this.description = description;
    }
}
