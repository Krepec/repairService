package pl.krepec.repairservice.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.Repair;
import pl.krepec.repairservice.repository.modelDAO.RepairDAO;
import pl.krepec.repairservice.service.RepairService;

import java.util.List;

@NoArgsConstructor
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

    @GetMapping("/id/{id}")
    public Repair findRepairById(@PathVariable ("id") Long repairId){
        return repairService.findByRepairId(repairId);
    }

    @PostMapping(value = "/repair", consumes = "application/json")
    public String addRepair(@RequestBody Repair repair){
        return repairService.addRepair(repair);
    }
}
