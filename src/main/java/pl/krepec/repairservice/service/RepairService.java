package pl.krepec.repairservice.service;

import pl.krepec.repairservice.dto.RepairDTO;

import java.util.List;

public interface RepairService {

    public List<RepairDTO> findAll();
    public RepairDTO findById(Long repairId);
    public String add(RepairDTO repairDTO);
}


