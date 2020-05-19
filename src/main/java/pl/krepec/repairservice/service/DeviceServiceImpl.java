package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dao.domain.Device;
import pl.krepec.repairservice.dao.repository.DeviceRepository;
import pl.krepec.repairservice.dto.DeviceDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {


    private final DeviceRepository deviceRepository;

    @Autowired
    private DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    private DeviceDTO mapDevice(Device device) {
        return new DeviceDTO(device.deviceId, device.model, device.serialNumber);

    }


    public DeviceDTO findOne(Long deviceId) {
        final Device Device = deviceRepository.findOne(deviceId);
        System.out.println(Device);
        return mapDevice(Device);

    }

    public List<DeviceDTO> findAll() {
        final List<Device> deviceList = deviceRepository.findAll();
        return deviceList
                .stream()
                .map(this::mapDevice)
                .collect(Collectors.toList());
    }

    public DeviceDTO findByModel(String model) {
        final Device device = deviceRepository.findByModel(model);
        return mapDevice(device);
    }

    public String add(DeviceDTO deviceDTO) {
        Device device = deviceRepository.save(new Device(deviceDTO.getDeviceId(),
                deviceDTO.getModel(), deviceDTO.getSerialNumber()));
        return "DeviceDTO " + device.model + "added";
    }


}