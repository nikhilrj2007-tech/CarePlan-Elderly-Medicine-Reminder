package careplan.controller;

import jakarta.validation.Valid;
import careplan.entity.Medicine;
import careplan.service.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping
    public Medicine addMedicine(@Valid @RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Optional<Medicine> getMedicineById(@PathVariable Long id) {
        return medicineService.getMedicineById(id);
    }
}
