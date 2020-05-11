package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.CustomerDTO;
import pl.krepec.repairservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/id/{id}")
    public CustomerDTO getById(@PathVariable("id") Long customerId) {
       return customerService.findById(customerId);
    }

    @GetMapping("/phone/{phone}")
    public CustomerDTO getByPhoneNumber(@PathVariable("phone") String phoneNumber) {
        return customerService.findByPhoneNumber(phoneNumber);
    }


    @PostMapping(value = "/customerDTO" ,  consumes = "application/json" )
    public String add(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }
}
