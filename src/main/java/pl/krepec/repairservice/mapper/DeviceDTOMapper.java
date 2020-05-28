package pl.krepec.repairservice.mapper;

import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Device;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dto.DeviceDTO;

import java.util.List;

@Component
public class DeviceDTOMapper {

    public DeviceDTO deviceDTOfromDevice(Device device) {
        return new DeviceDTO(device.getId(), device.getModel(), device.getSerialNumber());

    }

    public Device deviceDTOtoDevice(DeviceDTO deviceDTO) {
        return new Device(deviceDTO.getId(), deviceDTO.getModel(), deviceDTO.getSerialNumber());

    }
}
