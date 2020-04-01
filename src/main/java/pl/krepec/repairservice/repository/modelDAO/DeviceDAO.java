package pl.krepec.repairservice.repository.modelDAO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class DeviceDAO {

    private Long COUNTER_DEVICE_DAO_OBJECTS;

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

    public DeviceDAO(Long deviceId, String model, String serialNumber) {

        COUNTER_DEVICE_DAO_OBJECTS++;

        this.deviceId = deviceId;
        this.model = model;
        this.serialNumber = serialNumber;

    }


}

