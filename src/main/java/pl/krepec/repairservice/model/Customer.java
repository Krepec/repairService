package pl.krepec.repairservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private static Long COUNTER_CUSTOMER_OBJECTS;

    private Long customerId;
    private String name;
    private String surname;
    private String phoneNumber;

    public Customer(Long customerId, String name, String surname, String phoneNumber) {

        COUNTER_CUSTOMER_OBJECTS++;

        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }
}