package pl.krepec.repairservice.repository.modelDAO;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerDAO {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @NotNull
        @Column (name = "customer_Id")
        private Long customerId;

        @NotNull
        @Column (name = "name")
        private String name;

        @Column (name = "surname")
        private String surname;

        @NotNull
        @Column(name = "phoneNumber")
        private String phoneNumber;

        @OneToMany(mappedBy = "customer")
        private List<RepairDAO> repair;

        public CustomerDAO(Long customerId, String name, String surname, String phoneNumber) {


                this.customerId = 0L;
                this.name = name;
                this.surname = surname;
                this.phoneNumber = phoneNumber;
        }




}
