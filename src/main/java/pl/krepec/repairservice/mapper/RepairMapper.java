package pl.krepec.repairservice.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dto.RepairDTO;

@Component
@Data
public class RepairMapper {

    private final CustomerMapper customerMapper;
    private final DeviceMapper deviceMapper;

    @Autowired
    public RepairMapper(CustomerMapper customerMapper, DeviceMapper deviceMapper) {
        this.customerMapper = customerMapper;
        this.deviceMapper = deviceMapper;
    }

    public RepairDTO mapRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getRepairNumber(), repair.getStatus(), repair.getIssue(),
                repair.getDescription(), repair.getStartDate(), repair.getEndDate(), repair.getRepairResult(),
                customerMapper.mapCustomer(repair.getCustomer()), deviceMapper.mapDevice(repair.getDevice()));

    }

    public Repair mapRepairDTO(RepairDTO repair) {
        return new Repair(repair.getRepairId(), repair.getRepairNumber(), repair.getStatus(), repair.getIssue(),
                repair.getDescription(), repair.getStartDate(), repair.getEndDate(), repair.getRepairResult(),
                customerMapper.mapCustomerDTO(repair.getCustomer()), deviceMapper.mapDeviceDTO(repair.getDevice()));
    }
}
