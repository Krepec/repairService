package pl.krepec.repairservice.model;

import lombok.*;
import pl.krepec.repairservice.Status;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Repair {

    private Long COUNTER_DEVICE_OBJECTS = 0L;

    public Long repairId;
    public Long customerId;
    public Long deviceId;
    public Status status;
    public String issue;
    public String description;

    public Repair(Long repairId, Long customerId, Long deviceId, Status status, String issue, String description) {

        COUNTER_DEVICE_OBJECTS++;

        this.repairId = repairId;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.status = status;
        this.issue = issue;
        this.description = description;
    }
}
