package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.Device;
import pl.krepec.repairservice.repository.modelDAO.DeviceDAO;
import pl.krepec.repairservice.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private DeviceService deviceService;

    @Autowired
    private DeviceController (DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    public List findAllDevices(){
        return deviceService.findAllDevice();
    }

    @GetMapping("/{id}")
    public Device getById(@PathVariable("id") Long deviceId){
        return deviceService.findOne(deviceId);
    }
    @GetMapping("/model")
    public Device findByModel(@PathVariable("id") String model){
        return deviceService.findByModel(model);
    }

    @PostMapping(value = "/device", consumes = "application/json" )
    public String addDevice(@RequestBody DeviceDAO deviceDAO){
       return deviceService.addDevice(deviceDAO);
    }
}
