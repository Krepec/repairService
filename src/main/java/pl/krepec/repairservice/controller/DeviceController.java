package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.krepec.repairservice.model.Device;
import pl.krepec.repairservice.service.DeviceService;

import java.util.List;

@RestController
@RequestMapping("/repairService")
public class DeviceController {

    private DeviceService deviceService;

    @Autowired
    private DeviceController (DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    public List getAllDevices(){
        return deviceService.findAll();
    }

    @GetMapping("/{id}")
    public Device getById(@PathVariable("id") Long deviceId){
        return deviceService.findOne(deviceId);

    }

}
