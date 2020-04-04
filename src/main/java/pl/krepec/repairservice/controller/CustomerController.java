package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.Customer;
import pl.krepec.repairservice.repository.modelDAO.CustomerDAO;
import pl.krepec.repairservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/customer")
    public List<CustomerDAO> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/id/{id}")
    public Customer getById(@PathVariable("id") Long customerId) {
       return customerService.findById(customerId);
    }

    @GetMapping("/phone/{phone}")
    public Customer getByPhoneNumber(@PathVariable("phone") String phoneNumber) {
        return customerService.findByPhoneNumber(phoneNumber);
    }

    @PostMapping(value = "/customer" ,  consumes = "application/json" )
    public String addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
}
