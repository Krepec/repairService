package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.dto.DeviceDTO;
import pl.krepec.repairservice.service.DeviceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private final DeviceServiceImpl deviceServiceImpl;

    @Autowired
    private DeviceController (DeviceServiceImpl deviceServiceImpl){
        this.deviceServiceImpl = deviceServiceImpl;
    }

    @GetMapping("/device")
    private List<DeviceDTO> findAll(){
        return deviceServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public DeviceDTO getById(@PathVariable("id") Long deviceId){
        return deviceServiceImpl.findOne(deviceId);
    }

    @GetMapping("/model")
    public DeviceDTO findByModel(@PathVariable("model") String model){
        return deviceServiceImpl.findByModel(model);
    }

    @PostMapping(value = "/deviceDTO", consumes = "application/json")
    public String addDevice(@RequestBody DeviceDTO deviceDTO){
       return deviceServiceImpl.add(deviceDTO);
    }
}
