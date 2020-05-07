package pl.krepec.repairservice.service;

import pl.krepec.repairservice.model.DeviceDTO;

import java.util.List;

public interface DeviceService {


     DeviceDTO findOne(Long deviceId);
     List<DeviceDTO> findAll();
     DeviceDTO findByModel(String model);
     String add(DeviceDTO deviceDTO);

}