package pl.krepec.repairservice.dao.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.krepec.repairservice.common.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "repair")
public class Repair {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "repair_id")
    public Long repairId;

    @NotNull
    @Column(name = "customer_id")
    public Long customerId;

    @NotNull
    @Column(name = "device_id")
    public Long deviceId;

    @NotNull
    @Column
    public String repairNumber;

    @NotNull
    @Column(name = "status")
    public Status status;

    @NotNull
    @Column(name = "issue")
    public String issue;

    @NotNull
    @Column(name = "description")
    public String description;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    public Repair(Long repairId, Long customerId, Long deviceId, String repairNumber, Status status, String issue, String description) {

        this.repairId = 0L;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.repairNumber = repairNumber;
        this.status = Status.INPROGRES;
        this.issue = issue;
        this.description = description;
    }
}

