package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.DAO.model.Repair;
import pl.krepec.repairservice.DAO.repository.RepairRepository;
import pl.krepec.repairservice.model.RepairDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;

    @Autowired
    private RepairServiceImpl(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public RepairDTO findById2(Long repairId) {
        final Repair repair = repairRepository.findOne(repairId);
        return  mapRepair(repair);
    }



    private RepairDTO mapRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getCustomerId(), repair.getDeviceId(),
                repair.getStatus(), repair.getIssue(), repair.getDescription());
    }


    public List<RepairDTO> findAll() {
        final List<Repair> repairList = repairRepository.findAll();
        return repairList
                .stream()
                .map(this::mapRepair)
                .collect(Collectors.toList());
    }

    public RepairDTO findById(Long repairId) {
        final Repair repair = repairRepository.findOne(repairId);
        return  mapRepair(repair);
    }

    public String add(RepairDTO repairDTO) {
       final Repair newReapirDAO = repairRepository.save(new Repair(repairDTO.getRepairId(), repairDTO.getCustomerId(), repairDTO.getDeviceId(),
                repairDTO.getStatus(), repairDTO.getIssue(), repairDTO.getDescription()));
        return "Naprawa dodana, numer naprawy: " + newReapirDAO.getRepairId();

    }
}


