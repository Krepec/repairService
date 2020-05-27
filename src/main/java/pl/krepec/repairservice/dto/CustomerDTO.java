package pl.krepec.repairservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class CustomerDTO {


    private Long customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public CustomerDTO(Long customerId, String firstName, String lastName, String phoneNumber) {


        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}