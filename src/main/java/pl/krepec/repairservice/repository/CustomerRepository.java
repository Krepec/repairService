package pl.krepec.repairservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.repository.modelDAO.CustomerDAO;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDAO, Long> {
    CustomerDAO findByPhoneNumber(String phoneNumber);
}
