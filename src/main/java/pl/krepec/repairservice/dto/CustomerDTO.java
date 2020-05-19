package pl.krepec.repairservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
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