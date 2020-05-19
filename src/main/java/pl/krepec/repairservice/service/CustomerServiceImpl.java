package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dto.CustomerDTO;
import pl.krepec.repairservice.dao.repository.CustomerRepository;
import pl.krepec.repairservice.dao.domain.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {



    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private CustomerDTO mapCustomer(Customer customer) {
        return new CustomerDTO(customer.customerId, customer.firstName, customer.lastName, customer.phoneNumber);
    }


    @Override
    public List<CustomerDTO> findAll() {
        final List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(this::mapCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long customerId) {
        final Customer customer = customerRepository.findOne(customerId);
        System.out.println(customer);
        return mapCustomer(customer);
    }


    @Override
    public CustomerDTO findByPhoneNumber(String phoneNumber) {
        final Customer customer = customerRepository.findByPhoneNumber(phoneNumber);
        return mapCustomer(customer);
    }

    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        final Customer customer = customerRepository.save(new Customer(customerDTO.getCustomerId(), customerDTO.getName(), customerDTO.getSurname(), customerDTO.getPhoneNumber()));
        return "User " + customer.getFirstName() + " added";
    }

}
