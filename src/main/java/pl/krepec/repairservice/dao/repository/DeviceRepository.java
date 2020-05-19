package pl.krepec.repairservice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krepec.repairservice.dao.domain.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    Device findByModel(String model);
}
