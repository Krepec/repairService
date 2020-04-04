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
    private DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    private Device mapDevice(DeviceDAO deviceDAO) {
        return new Device(deviceDAO.deviceId, deviceDAO.model, deviceDAO.serialNumber);

    }


    public Device findOne(Long deviceId) {
        DeviceDAO mapedDeviceDAD = deviceRepository.findOne(deviceId);
        return mapDevice(mapedDeviceDAD);

    }

    public List<DeviceDAO> findAllDevice() {
        return deviceRepository.findAll();
    }

    public Device findByModel(String model) {
        DeviceDAO deviceDAO = deviceRepository.findByModel(model);
        return mapDevice(deviceDAO);
    }

    public String addDevice(Device device) {
        DeviceDAO deviceDAO =  deviceRepository.save(new  DeviceDAO(device.getDeviceId(),
                device.getModel(),device.getSerialNumber()));
        return "Device " + deviceDAO.model + "added";
    }


}