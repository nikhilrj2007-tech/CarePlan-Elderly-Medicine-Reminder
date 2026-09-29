package careplan.controller;

import jakarta.validation.Valid;
import careplan.entity.Schedule;
import careplan.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @PostMapping
    public Schedule addSchedule(@Valid @RequestBody Schedule schedule) {
        return scheduleService.saveSchedule(schedule);
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }
    @GetMapping("/today")
    public List<Schedule> getTodaySchedules() {
        return scheduleService.getTodaySchedules();
    }

    @GetMapping("/{id}")
    public Optional<Schedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }
        @GetMapping("/overdue")
        public List<Schedule> getOverdueSchedules() {
            return scheduleService.getOverdueSchedules();
        }

}
