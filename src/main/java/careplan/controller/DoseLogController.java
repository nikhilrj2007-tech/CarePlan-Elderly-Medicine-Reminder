package careplan.controller;

import jakarta.validation.Valid;
import careplan.entity.DoseLog;
import careplan.service.DoseLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dose-logs")
public class DoseLogController {

    private final DoseLogService doseLogService;

    public DoseLogController(DoseLogService doseLogService) {
        this.doseLogService = doseLogService;
    }

    @PostMapping
    public DoseLog addDoseLog(@Valid @RequestBody DoseLog doseLog) {
        return doseLogService.saveDoseLog(doseLog);
    }

    @GetMapping
    public List<DoseLog> getAllDoseLogs() {
        return doseLogService.getAllDoseLogs();
    }
    @GetMapping("/missed")
    public List<DoseLog> getMissedDoseLogs() {
        return doseLogService.getMissedDoseLogs();
    }

    @GetMapping("/{id}")
    public Optional<DoseLog> getDoseLogById(@PathVariable Long id) {
        return doseLogService.getDoseLogById(id);
    }
}
