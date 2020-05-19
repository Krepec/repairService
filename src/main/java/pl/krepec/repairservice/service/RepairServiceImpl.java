package pl.krepec.repairservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krepec.repairservice.dao.domain.Repair;
import pl.krepec.repairservice.dao.repository.RepairRepository;
import pl.krepec.repairservice.dto.RepairDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements RepairService {

    private final RepairRepository repairRepository;
    private Date date;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    private Integer counter = 0;

    @Autowired
    private RepairServiceImpl(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    private RepairDTO mapRepair(Repair repair) {
        return new RepairDTO(repair.getRepairId(), repair.getCustomerId(), repair.getDeviceId(),repair.getRepairNumber(),
                repair.getStatus(), repair.getIssue(), repair.getDescription());
    }

    private String createRepairNumber() {
        String nowDate = simpleDateFormat.format(date.getTime());
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

    public String add(RepairDTO repairDTO) {
        final Repair newReapirDAO = repairRepository.save(new Repair(repairDTO.getRepairId(), repairDTO.getCustomerId(), repairDTO.getDeviceId(),
                repairDTO.getRepairNumber(), repairDTO.getStatus(), repairDTO.getIssue(), repairDTO.getDescription()));
        return "Naprawa dodana, numer naprawy: " + newReapirDAO.getRepairId();

    }
}


