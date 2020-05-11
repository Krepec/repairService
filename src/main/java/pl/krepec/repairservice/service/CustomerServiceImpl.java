package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.CustomerDTO;
import pl.krepec.repairservice.DAO.repository.CustomerRepository;
import pl.krepec.repairservice.DAO.model.Customer;

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
        return new CustomerDTO(customer.customerId, customer.name, customer.surname, customer.phoneNumber);
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
        return "User " + customer.getName() + " added";
    }

}
