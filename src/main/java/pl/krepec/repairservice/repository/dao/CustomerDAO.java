package pl.krepec.repairservice.repository.dao;

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
        @GeneratedValue
        @Column (name = "customerId")
        @NotNull
        private Long customerId;

        @Column (name = "name")
        @NotNull
        private String name;

        @Column (name = "surname")
        private String surname;

        @Column(name = "phone_number")
        private String phoneNumber;


        public CustomerDAO(String name, String surname, String phoneNumber) {
        }
}
