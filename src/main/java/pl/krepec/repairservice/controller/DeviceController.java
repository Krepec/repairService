package pl.krepec.repairservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.krepec.repairservice.model.Device;
import pl.krepec.repairservice.service.DeviceService;

@Controller
@RequestMapping("/device")
public class DeviceController {

    private DeviceService deviceService;

    @Autowired
    private DeviceController (DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    public String findAllDevices(Model model){
        System.out.println(model.addAttribute("device", deviceService.findAllDevice()));
        return "device";
    }

    @GetMapping("/{id}")
    public Device getById(@PathVariable("id") Long deviceId){
        return deviceService.findOne(deviceId);
    }

    @GetMapping("/model")
    public Device findByModel(@PathVariable("model") String model){
        return deviceService.findByModel(model);
    }

    @PostMapping(value = "/device", consumes = "application/json")
    public String addDevice(@RequestBody Device device){
       return deviceService.addDevice(device);
    }
}
