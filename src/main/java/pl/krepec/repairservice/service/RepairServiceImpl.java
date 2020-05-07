package pl.krepec.repairservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.RepairDTO;
import pl.krepec.repairservice.DAO.repository.RepairRepository;
import pl.krepec.repairservice.DAO.model.Repair;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RepairServiceImpl implements RepairService {

    private RepairRepository repairRepository;

    @Autowired
    private RepairServiceImpl(RepairRepository repairRepository, DeviceServiceImpl deviceService) {
        this.repairRepository = repairRepository;
    }

    private RepairDTO mapRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getCustomerId(), repair.getDeviceId(),
                repair.getStatus(), repair.getIssue(), repair.getDescription());
    }


    public List<RepairDTO> findAll() {
    List<Repair> repairList = repairRepository.findAll();
        return repairList
                .stream()
                .map(this::mapRepair)
                .collect(Collectors.toList());
    }

    public RepairDTO findById(Long repairId) {
        return mapRepair(repairRepository.findOne(repairId));
    }

    public String add(RepairDTO repairDTO) {
        Repair newReapirDAO = repairRepository.save(new Repair(repairDTO.getRepairId(), repairDTO.getCustomerId(), repairDTO.getDeviceId(),
                repairDTO.getStatus(), repairDTO.getIssue(), repairDTO.getDescription()));
        return "Naprawa dodana, numer naprawy: " + newReapirDAO.getRepairId();

    }
}


