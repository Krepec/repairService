package pl.krepec.repairservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class CustomerDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;


}