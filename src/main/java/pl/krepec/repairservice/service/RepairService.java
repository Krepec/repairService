package pl.krepec.repairservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.Repair;
import pl.krepec.repairservice.repository.RepairRepository;
import pl.krepec.repairservice.repository.modelDAO.RepairDAO;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RepairService {

    private RepairRepository repairRepository;
    private List<Repair> repairList;

    @Autowired
    public RepairService(RepairRepository repairRepository, DeviceService deviceService) {
        this.repairRepository = repairRepository;
    }

    private Repair mapRepair(RepairDAO repairDAO) {
        return new Repair(repairDAO.getRepairId(), repairDAO.getCustomerId(), repairDAO.getDeviceId(),
                repairDAO.getStatus(), repairDAO.getIssue(), repairDAO.getDescription());
    }

    private List<Repair> mapRepairList(List<RepairDAO> repairDAOList) {
        for (RepairDAO repairDAO : repairDAOList) {
            repairList.add(mapRepair(repairDAO));
        }
        return repairList;
    }

    public List<RepairDAO> finAllRepairs() {

        return repairRepository.findAll();
    }

    public Repair findByRepairId(Long repairId) {
        return mapRepair(repairRepository.findOne(repairId));
    }

    public String addRepair(Repair repair) {
        RepairDAO newReapirDAO = repairRepository.save(new RepairDAO(repair.getRepairId(), repair.getCustomerId(), repair.getDeviceId(),
                repair.getStatus(), repair.getIssue(), repair.getDescription()));
        return "Naprawa dodana, numer naprawy: " + newReapirDAO.getRepairId();

    }
}


