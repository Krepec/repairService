package pl.krepec.repairservice.service;

import pl.krepec.repairservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> findAll();
    CustomerDTO findById(Long customerId);
    CustomerDTO findByPhoneNumber(String phoneNumber);
    CustomerDTO add(CustomerDTO customerDTO);
}
