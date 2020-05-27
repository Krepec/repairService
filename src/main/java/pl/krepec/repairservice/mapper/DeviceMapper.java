package pl.krepec.repairservice.mapper;

import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Device;
import pl.krepec.repairservice.dto.DeviceDTO;

@Component
public class DeviceMapper {

    public DeviceDTO mapDevice(Device device) {
        return new DeviceDTO(device.deviceId, device.model, device.serialNumber);

    }

    public Device mapDeviceDTO(DeviceDTO deviceDTO) {
        return new Device(deviceDTO.deviceId, deviceDTO.model, deviceDTO.serialNumber);

    }
}
