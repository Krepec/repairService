package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dto.CustomerDTO;
import pl.krepec.repairservice.dao.repository.CustomerRepository;
import pl.krepec.repairservice.dao.domain.Customer;
import pl.krepec.repairservice.mapper.CustomerDTOMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {



    private final CustomerRepository customerRepository;
    private final CustomerDTOMapper customerDTOMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDTOMapper customerDTOMapper) {
        this.customerRepository = customerRepository;
        this.customerDTOMapper = customerDTOMapper;
    }

    @Override
    public List<CustomerDTO> findAll() {
        final List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customerDTOMapper::customerDTOfromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long customerId) {
        final Customer customer = customerRepository.findOne(customerId);
        System.out.println(customer);
        return customerDTOMapper.customerDTOfromCustomer(customer);
    }


    @Override
    public CustomerDTO findByPhoneNumber(String phoneNumber) {
        final Customer customer = customerRepository.findByPhoneNumber(phoneNumber);
        return customerDTOMapper.customerDTOfromCustomer(customer);
    }

    @Override
    public CustomerDTO add(CustomerDTO customerDTO) {
        final Customer customer = customerRepository.save(new Customer(customerDTO.getId(), customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getPhoneNumber()));
        return customerDTOMapper.customerDTOfromCustomer(customer);

    }

}
