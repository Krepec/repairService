package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dto.RepairDTO;
import pl.krepec.repairservice.service.RepairService;

import java.util.List;

@RestController
@RequestMapping("/repair")
public class RepairController {

    private final RepairService repairService;

    @Autowired
    private RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping("/repair")
    public List<RepairDTO> findAll(){
        return repairService.findAll();
    }

    @GetMapping("/id/{id}")
    public RepairDTO findById(@PathVariable ("id") Long repairId){
        return repairService.findById(repairId);
    }

    @PostMapping(value = "/repairDTO", consumes = "application/json")
    public RepairDTO add(@RequestBody RepairDTO repairDTO){
        return repairService.add(repairDTO);
    }
}
