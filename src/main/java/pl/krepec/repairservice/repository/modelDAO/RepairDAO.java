package pl.krepec.repairservice.repository.modelDAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.krepec.repairservice.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "repair")
public class RepairDAO {


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
    private DeviceDAO device;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private CustomerDAO customer;

    public RepairDAO(Long repairId, Long customerId, Long deviceId, Status status, String issue, String description) {

        this.repairId = 0L;
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.status = status.INPROGRES;
        this.issue = issue;
        this.description = description;
    }
}

