package pl.krepec.repairservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.repository.modelDAO.DeviceDAO;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceDAO,Long> {
    DeviceDAO findByModel(String model);
}
