package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.Device;
import pl.krepec.repairservice.repository.DeviceRepository;
import pl.krepec.repairservice.repository.modelDAO.DeviceDAO;

import java.util.List;

@Service
public class DeviceService {


    private DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    private Device mapDevice(DeviceDAO deviceDAO) {
        return new Device(deviceDAO.deviceId, deviceDAO.model, deviceDAO.serialNumber, deviceDAO.issue, deviceDAO.description);


    }


    public Device findOne(Long deviceId) {
        DeviceDAO mapedDeviceDAD = deviceRepository.findOne(deviceId);
        return mapDevice(mapedDeviceDAD);

    }

    public List<DeviceDAO> findAll() {
        return deviceRepository.findAll();
    }
}