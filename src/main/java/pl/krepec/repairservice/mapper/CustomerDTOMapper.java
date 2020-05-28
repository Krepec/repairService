package pl.krepec.repairservice.mapper;

import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Customer;
import pl.krepec.repairservice.dto.CustomerDTO;

@Component
public class CustomerDTOMapper {

    public CustomerDTO customerDTOfromCustomer(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber());
    }

    public Customer customerDTOtoCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO.getId(), customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getPhoneNumber());
    }
}
