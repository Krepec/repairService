package pl.krepec.repairservice.controller;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.RepairDTO;
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
    public List<RepairDTO> findAll(){
        return repairService.findAll();
    }

    @GetMapping("/id/{id}")
    public RepairDTO findById(@PathVariable ("id") Long repairId){
        return repairService.findById(repairId);
    }

    @PostMapping(value = "/repairDTO", consumes = "application/json")
    public String add(@RequestBody RepairDTO repairDTO){
        return repairService.add(repairDTO);
    }
}
