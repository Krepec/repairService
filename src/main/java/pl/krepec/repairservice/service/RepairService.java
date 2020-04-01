package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.model.Repair;
import pl.krepec.repairservice.repository.RepairRepository;
import pl.krepec.repairservice.repository.modelDAO.RepairDAO;

import java.util.List;

@Service
public class RepairService {

    private RepairRepository repairRepository;

    @Autowired
    private RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    private Repair mapRepair(RepairDAO repairDAO) {
        return new Repair(repairDAO.getRepairId(), repairDAO.getCustomerId(), repairDAO.getDeviceId(),
                repairDAO.getStatus(), repairDAO.getIssue(), repairDAO.getDescription());
    }

//    private List<Repair> mapRepairList(List<RepairDAO> repairDAOList) {
//            repairDAOList
//
//    }

    public List<RepairDAO> finAllRepairs() {
        return repairRepository.findAll();
    }

    public Repair findByRepairId(Long repairId){
        return mapRepair(repairRepository.findOne(repairId));
    }

    public List<Repair> findRepairBySerialNumber(String serialNumber){
        return repairRepository.findRepairBySerialNumber(serialNumber);
    }

}
