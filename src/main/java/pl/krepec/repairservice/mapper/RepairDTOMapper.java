package pl.krepec.repairservice.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dto.RepairDTO;

@Component
@Data

public class RepairDTOMapper {

    private final CustomerDTOMapper customerDTOMapper;
    private final DeviceDTOMapper deviceDTOMapper;

    @Autowired
    public RepairDTOMapper(CustomerDTOMapper customerDTOMapper, DeviceDTOMapper deviceDTOMapper) {
        this.customerDTOMapper = customerDTOMapper;
        this.deviceDTOMapper = deviceDTOMapper;
    }

    public RepairDTO repairDTOfromRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getRepairNumber(), repair.getStatus(), repair.getIssue(),
                repair.getDescription(), repair.getStartDate(), repair.getEndDate(), repair.getRepairResult(),
                customerDTOMapper.customerDTOfromCustomer(repair.getCustomer()), deviceDTOMapper.deviceDTOfromDevice(repair.getDevice()));

    }

    public Repair repairDTOtoRepair(RepairDTO repairDTO) {
        return new Repair(repairDTO.getRepairId(), repairDTO.getRepairNumber(), repairDTO.getStatus(), repairDTO.getIssue(),
                repairDTO.getDescription(), repairDTO.getStartDate(), repairDTO.getEndDate(), repairDTO.getRepairResult(),
                customerDTOMapper.customerDTOtoCustomer(repairDTO.getCustomer()), deviceDTOMapper.deviceDTOtoDevice(repairDTO.getDevice()));
    }
}
