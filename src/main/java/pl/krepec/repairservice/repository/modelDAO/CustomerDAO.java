package pl.krepec.repairservice.repository.modelDAO;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerDAO {

        private static Long COUNTER_CUSTOMER_DAO_OBJECTS;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @NotNull
        @Column (name = "customerId")
        private Long customerId;

        @NotNull
        @Column (name = "name")
        private String name;

        @Column (name = "surname")
        private String surname;

        @NotNull
        @Column(name = "phoneNumber")
        private String phoneNumber;


        public CustomerDAO(Long customerId, String name, String surname, String phoneNumber) {

                COUNTER_CUSTOMER_DAO_OBJECTS++;

                this.customerId = customerId;
                this.name = name;
                this.surname = surname;
                this.phoneNumber = phoneNumber;
        }




}
