package pl.krepec.repairservice.service;

import pl.krepec.repairservice.dto.DeviceDTO;

import java.util.List;

public interface DeviceService {


     DeviceDTO findOne(Long deviceId);
     List<DeviceDTO> findAll();
     DeviceDTO findByModel(String model);
     DeviceDTO add(DeviceDTO deviceDTO);

}