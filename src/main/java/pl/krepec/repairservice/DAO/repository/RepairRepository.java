package pl.krepec.repairservice.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.DAO.model.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

}
