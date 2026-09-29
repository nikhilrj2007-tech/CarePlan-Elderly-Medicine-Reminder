package careplan.service;

import careplan.entity.DoseLog;
import careplan.repository.DoseLogRepository;
import org.springframework.stereotype.Service;
import careplan.exception.DuplicateDoseException;

import java.util.List;
import java.util.Optional;

@Service
public class DoseLogService {

    private final DoseLogRepository doseLogRepository;

    public DoseLogService(DoseLogRepository doseLogRepository) {
        this.doseLogRepository = doseLogRepository;
    }

    public DoseLog saveDoseLog(DoseLog doseLog) {

        Optional<DoseLog> existingLog =
                doseLogRepository.findByScheduleId(
                        doseLog.getSchedule().getId()
                );

        if (existingLog.isPresent()) {
            throw new DuplicateDoseException(
                    "A dose log already exists for this schedule."
            );
        }

        return doseLogRepository.save(doseLog);
    }

    public List<DoseLog> getAllDoseLogs() {
        return doseLogRepository.findAll();
    }
    public List<DoseLog> getMissedDoseLogs() {
        return doseLogRepository.findByStatusIgnoreCase("MISSED");
    }

    public Optional<DoseLog> getDoseLogById(Long id) {
        return doseLogRepository.findById(id);
    }
}