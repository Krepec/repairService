package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.dto.Customer;
import pl.krepec.repairservice.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
