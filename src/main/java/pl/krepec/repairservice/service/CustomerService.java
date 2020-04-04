package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.Customer;
import pl.krepec.repairservice.repository.modelDAO.CustomerDAO;
import pl.krepec.repairservice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    private CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Customer mapCustomer(CustomerDAO customerDAO) {
        return new Customer(customerDAO.getCustomerId(), customerDAO.getName(), customerDAO.getSurname(), customerDAO.getPhoneNumber());

    }

    public List<CustomerDAO> findAllCustomers() {
        return customerRepository.findAll();
    }


    public Customer findById(Long customerId) {
        CustomerDAO customerDAO = customerRepository.findOne(customerId);
        return mapCustomer(customerDAO);

    }

    public Customer findByPhoneNumber(String phoneNumber) {
        Customer customer = mapCustomer(customerRepository.findByPhoneNumber(phoneNumber));
        return customer;

    }


    public String addCustomer(Customer customer) {
        CustomerDAO customerDAO = customerRepository.save(new CustomerDAO(customer.getCustomerId(), customer.getName(), customer.getSurname(), customer.getPhoneNumber()));
        return "User " + customerDAO.getName() + " added";
    }

}
