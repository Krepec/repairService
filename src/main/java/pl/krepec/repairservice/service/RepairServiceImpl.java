package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dao.repository.RepairRepository;
import pl.krepec.repairservice.dto.RepairDTO;
import pl.krepec.repairservice.mapper.CustomerMapper;
import pl.krepec.repairservice.mapper.DeviceMapper;
import pl.krepec.repairservice.mapper.RepairMapper;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final CustomerMapper customerMapper;
    private final DeviceMapper deviceMapper;
    private final RepairMapper repairMapper;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private Integer counter = 0;

    @Autowired
    private RepairServiceImpl(RepairRepository repairRepository, CustomerMapper customerMapper, DeviceMapper deviceMapper, RepairMapper repairMapper) {
        this.repairRepository = repairRepository;
        this.customerMapper = customerMapper;
        this.deviceMapper = deviceMapper;
        this.repairMapper = repairMapper;
    }

    private RepairDTO mapRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getRepairNumber(), repair.getStatus(), repair.getIssue(),
                repair.getDescription(), repair.getStartDate(), repair.getEndDate(), repair.getRepairResult(),
                customerMapper.mapCustomer(repair.getCustomer()), deviceMapper.mapDevice(repair.getDevice()));

    }

    private Repair mapRepairDTO(RepairDTO repair) {
        return new Repair(repair.getRepairId(), repair.getRepairNumber(), repair.getStatus(), repair.getIssue(),
                repair.getDescription(), repair.getStartDate(), repair.getEndDate(), repair.getRepairResult(),
                customerMapper.mapCustomerDTO(repair.getCustomer()), deviceMapper.mapDeviceDTO(repair.getDevice()));
    }

    private String createRepairNumber() {
        String nowDate = formatter.format(OffsetDateTime.now());
        String repairNumber = nowDate + counter;
        if (counter >= 0 && counter > 1000) {
            counter++;
        } else {
            counter = 0;
        }
        return repairNumber;
    }

    public List<RepairDTO> findAll() {
        final List<Repair> repairList = repairRepository.findAll();
        return repairList
                .stream()
                .map(this::mapRepair)
                .collect(Collectors.toList());
    }

    public RepairDTO findById(Long repairId) {
        final Repair repair = repairRepository.findOne(repairId);
        System.out.println(repair);
        return mapRepair(repair);
    }

    public RepairDTO add(RepairDTO repairDTO) {
        String reapirNumber = createRepairNumber();
        Repair saveRepair = repairRepository.save(new RepairDTO(repairDTO.getRepairId(), repairDTO.getRepairNumber(),
                repairDTO.getStatus(), repairDTO.getIssue(), repairDTO.getDescription(), repairDTO.getStartDate(), repairDTO.getEndDate(),
                repairDTO.getRepairResult(), repairDTO.getCustomer(), repairDTO.getDevice()));
        return mapRepair(saveRepair);


    }


}


