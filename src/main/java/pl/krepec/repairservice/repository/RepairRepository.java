package pl.krepec.repairservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.model.Repair;
import pl.krepec.repairservice.repository.modelDAO.RepairDAO;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<RepairDAO, Long> {
    List<Repair> findRepairBySerialNumber(String serialNumber);
}
