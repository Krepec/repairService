package pl.krepec.repairservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long customerId;
    private String name;
    private String surname;
    private String phoneNumber;



}