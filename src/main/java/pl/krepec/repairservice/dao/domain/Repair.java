package pl.krepec.repairservice.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.krepec.repairservice.common.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@Entity
@Table(name = "repair")
public class Repair {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "repair_id")
    public Long repairId;

    @NotNull
    @Column(name = "repair_number")
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

    @NotNull
    @Column(name = "start_Date")
    public OffsetDateTime startDate;

    @NotNull
    @Column(name = "endt_Date")
    public OffsetDateTime endDate;

    @NotNull
    @Column(name = "repair_result")
    public String repairResult;


    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "device_id", insertable = false, updatable = false)
    private Device device;




}

