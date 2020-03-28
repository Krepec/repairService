package pl.krepec.repairservice.repository.modelDAO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device")
public class DeviceDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "device_id")
    public Long deviceId;

    @Column(name = "model")
    @NotNull
    public String model;

    @Column(name = "serial_number")
    @NotNull
    public String serialNumber;

    @Column(name = "issue")
    @NotNull
    public String issue;

    @Column(name = "description")
    @NotNull
    public String description;

}

