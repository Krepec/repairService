package pl.krepec.repairservice.service;

import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dto.RepairDTO;

import java.util.List;

public interface RepairService {

    List<RepairDTO> findAll();
    RepairDTO findById(Long repairId);
    RepairDTO add(RepairDTO repairDTO);
}


