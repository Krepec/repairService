package pl.krepec.repairservice.dao.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "device")
public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    public Long id;

    @NotNull
    @Column(name = "model")
    public String model;

    @NotNull
    @Column(name = "serial_number")
    public String serialNumber;

    @OneToMany(mappedBy = "device")
    private List<Repair> repair;


    public Device(Long id, String model, String serialNumber) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
    }
}

