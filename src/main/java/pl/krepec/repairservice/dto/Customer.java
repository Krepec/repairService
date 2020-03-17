package pl.krepec.repairservice.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Customer {

    private Long customerId;
    private String name;
    private String surname;
    private String phoneNumber;


    public Customer(Long customerId, String name, String surname, String phoneNumber) {
    }
}