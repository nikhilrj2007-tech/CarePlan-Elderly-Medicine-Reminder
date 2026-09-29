package careplan.repository;

import careplan.entity.DoseLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoseLogRepository extends JpaRepository<DoseLog, Long> {

    Optional<DoseLog> findByScheduleId(Long scheduleId);

    List<DoseLog> findByStatusIgnoreCase(String status);
}