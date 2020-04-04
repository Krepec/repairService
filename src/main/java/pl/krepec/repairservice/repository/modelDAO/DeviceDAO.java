package pl.krepec.repairservice.repository.modelDAO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class DeviceDAO {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "device_id")
    public Long deviceId;

    @NotNull
    @Column(name = "model")
    public String model;

    @NotNull
    @Column(name = "serial_number")
    public String serialNumber;

    @OneToMany(mappedBy = "customer")
    private List<RepairDAO> repair;

    public DeviceDAO(Long deviceId, String model, String serialNumber) {

        this.deviceId = 0L;
        this.model = model;
        this.serialNumber = serialNumber;

    }


}

