package pl.krepec.repairservice.dao.domain;

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
        @GeneratedValue(strategy = GenerationType.AUTO)
        @NotNull
        @Column (name = "customer_Id")
        public Long customerId;

        @NotNull
        @Column (name = "name")
        public String firstName;

        @Column (name = "lastName")
        public String lastName;

        @NotNull
        @Column(name = "phoneNumber")
        public String phoneNumber;

        @OneToMany(mappedBy = "customer")
        private List<Repair> repair;

        public Customer(Long customerId, String firstName, String lastName, String phoneNumber) {


                this.customerId = 0L;
                this.firstName = firstName;
                this.lastName = lastName;
                this.phoneNumber = phoneNumber;
        }




}
