package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dto.Customer;
import pl.krepec.repairservice.repository.CustomerRepository;
import pl.krepec.repairservice.repository.dao.CustomerDAO;

import java.util.List;

@Service
public class CustomerService {



    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Customer mapCustomer(CustomerDAO customerDAO){
        return new Customer(customerDAO.getCustomerId(),customerDAO.getName(), customerDAO.getSurname(), customerDAO.getPhoneNumber());

    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public String addCustomer(Customer customer){
        CustomerDAO customerDAO = customerRepository.save(new CustomerDAO(customer.getName(), customer.getSurname(), customer.getPhoneNumber()));
        return "User " + customerDAO.getName() + " added";
    }
}
