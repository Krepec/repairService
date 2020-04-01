package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krepec.repairservice.model.Repair;
import pl.krepec.repairservice.repository.modelDAO.RepairDAO;
import pl.krepec.repairservice.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    private RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/repair")
    public List<RepairDAO> findAllRepairs(){
        return repairService.finAllRepairs();
    }

    @GetMapping("/{id}")
    public Repair findRepairById(@PathVariable ("id") Long repairId){
        return repairService.findByRepairId(repairId);
    }

    @GetMapping("/{serialnumber}")
    public List<Repair> findRepairBySerialNumber(@PathVariable ("serialnumber") String serialNumber){
        return repairService.findRepairBySerialNumber(serialNumber);
    }

}
