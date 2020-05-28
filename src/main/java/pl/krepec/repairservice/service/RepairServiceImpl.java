package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dao.repository.RepairRepository;
import pl.krepec.repairservice.dto.RepairDTO;
import pl.krepec.repairservice.mapper.RepairDTOMapper;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private final RepairDTOMapper repairDTOMapper;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private Integer counter = 0;

    @Autowired
    private RepairServiceImpl(RepairRepository repairRepository, RepairDTOMapper repairDTOMapper) {
        this.repairRepository = repairRepository;
        this.repairDTOMapper = repairDTOMapper;
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
                .map(repairDTOMapper::repairDTOfromRepair)
                .collect(Collectors.toList());
    }

    public RepairDTO findById(Long repairId) {
        final Repair repair = repairRepository.findOne(repairId);
        System.out.println(repair);
        return repairDTOMapper.repairDTOfromRepair(repair);
    }

    public RepairDTO add(RepairDTO repairDTO) {
        String reapirNumber = createRepairNumber();
        Repair repair = repairRepository.save(new RepairDTO(repairDTO.getRepairId(), repairDTO.getRepairNumber(),
                repairDTO.getStatus(), repairDTO.getIssue(), repairDTO.getDescription(), repairDTO.getStartDate(),
                repairDTO.getEndDate(), repairDTO.getRepairResult(), repairDTO.getCustomer(), repairDTO.getDevice()));
        return repairDTOMapper.repairDTOfromRepair(repair);


    }


}


