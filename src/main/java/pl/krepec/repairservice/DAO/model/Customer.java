package pl.krepec.repairservice.DAO.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @NotNull
        @Column (name = "customer_Id")
        public Long customerId;

        @NotNull
        @Column (name = "name")
        public String name;

        @Column (name = "surname")
        public String surname;

        @NotNull
        @Column(name = "phoneNumber")
        public String phoneNumber;

        @OneToMany(mappedBy = "customer")
        private List<Repair> repair;

        public Customer(Long customerId, String name, String surname, String phoneNumber) {


                this.customerId = 0L;
                this.name = name;
                this.surname = surname;
                this.phoneNumber = phoneNumber;
        }




}
