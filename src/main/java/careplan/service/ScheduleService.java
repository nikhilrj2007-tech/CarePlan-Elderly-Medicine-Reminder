package careplan.service;

import careplan.entity.DoseLog;
import careplan.entity.Schedule;
import careplan.repository.DoseLogRepository;
import careplan.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final DoseLogRepository doseLogRepository;

    public ScheduleService(ScheduleRepository scheduleRepository,
                           DoseLogRepository doseLogRepository) {
        this.scheduleRepository = scheduleRepository;
        this.doseLogRepository = doseLogRepository;
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
    public List<Schedule> getTodaySchedules() {
        return scheduleRepository.findByDate(java.time.LocalDate.now());
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> getOverdueSchedules() {

        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);

        return scheduleRepository.findAll()
                .stream()
                .filter(schedule ->
                        LocalDateTime.of(
                                schedule.getDate(),
                                schedule.getTime()
                        ).isBefore(oneHourAgo)
                )
                .filter(schedule ->
                        !doseLogRepository
                                .findByScheduleId(schedule.getId())
                                .isPresent()
                )
                .collect(Collectors.toList());
    }
}