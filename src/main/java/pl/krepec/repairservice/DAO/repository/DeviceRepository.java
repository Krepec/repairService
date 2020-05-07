package pl.krepec.repairservice.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.DAO.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    Device findByModel(String model);
}
