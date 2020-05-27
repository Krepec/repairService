package pl.krepec.repairservice.mapper;

import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Customer;
import pl.krepec.repairservice.dto.CustomerDTO;

@Component
public class CustomerMapper {

    public CustomerDTO mapCustomer(Customer customer) {
        return new CustomerDTO(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber());
    }

    public Customer mapCustomerDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getCustomerId(), customerDTO.getFirstName(), customerDTO.getLastName()
                ,customerDTO.getPhoneNumber());
    }
}
