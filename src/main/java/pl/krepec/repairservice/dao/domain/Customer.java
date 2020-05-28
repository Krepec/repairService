package pl.krepec.repairservice.dao.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @NotNull
        @Column (name = "id")
        public Long id;

        @NotNull
        @Column (name = "first_name")
        public String firstName;

        @Column (name = "last_Name")
        public String lastName;

        @NotNull
        @Column(name = "phone_Number")
        public String phoneNumber;

        @OneToMany(mappedBy = "customer")
        public List<Repair> repair;

        public Customer(Long id, String firstName, String lastName, String phoneNumber) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.phoneNumber = phoneNumber;
        }
}
