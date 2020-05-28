package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dao.domain.Device;
import pl.krepec.repairservice.dao.repository.DeviceRepository;
import pl.krepec.repairservice.dto.DeviceDTO;
import pl.krepec.repairservice.mapper.DeviceDTOMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {


    private final DeviceRepository deviceRepository;
    private final DeviceDTOMapper deviceDTOMapper;

    @Autowired
    private DeviceServiceImpl(DeviceRepository deviceRepository, DeviceDTOMapper deviceDTOMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceDTOMapper = deviceDTOMapper;
    }


    public DeviceDTO findOne(Long deviceId) {
        final Device device = deviceRepository.findOne(deviceId);
        System.out.println(device);
        return deviceDTOMapper.deviceDTOfromDevice(device);

    }

    public List<DeviceDTO> findAll() {
        final List<Device> deviceList = deviceRepository.findAll();
        return deviceList
                .stream()
                .map(deviceDTOMapper::deviceDTOfromDevice)
                .collect(Collectors.toList());
    }

    public DeviceDTO findByModel(String model) {
        final Device device = deviceRepository.findByModel(model);
        return deviceDTOMapper.deviceDTOfromDevice(device);
    }

    public DeviceDTO add(DeviceDTO deviceDTO) {
        Device device = deviceRepository.save(new Device(deviceDTO.getId(),
                deviceDTO.getModel(), deviceDTO.getSerialNumber()));
        return deviceDTOMapper.deviceDTOfromDevice(device);
    }


}