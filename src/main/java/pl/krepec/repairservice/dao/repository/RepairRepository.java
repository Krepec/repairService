package pl.krepec.repairservice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.dao.domain.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

}
