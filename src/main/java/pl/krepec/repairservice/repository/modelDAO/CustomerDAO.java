package pl.krepec.repairservice.repository.modelDAO;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerDAO {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column (name = "customerId")
        @NotNull
        private Long customerId;

        @Column (name = "name")
        @NotNull
        private String name;

        @Column (name = "surname")
        private String surname;

        @Column(name = "phoneNumber")
        @NotNull
        private String phoneNumber;



}
