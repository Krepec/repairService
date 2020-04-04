package pl.krepec.repairservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Customer {

    public static Long COUNTER_CUSTOMER_OBJECTS = 0L;

    private Long customerId;
    private String name;
    private String surname;
    private String phoneNumber;

    public Customer(Long customerId, String name, String surname, String phoneNumber) {

        COUNTER_CUSTOMER_OBJECTS ++;

        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

}