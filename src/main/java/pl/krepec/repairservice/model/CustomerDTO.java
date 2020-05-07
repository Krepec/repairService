package pl.krepec.repairservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerDTO {


    private Long customerId;
    private String name;
    private String surname;
    private String phoneNumber;

    public CustomerDTO(Long customerId, String name, String surname, String phoneNumber) {


        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

}