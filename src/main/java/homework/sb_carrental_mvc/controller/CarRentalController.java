package homework.sb_carrental_mvc.controller;

import homework.sb_carrental_mvc.dto.CarDtoList;
import homework.sb_carrental_mvc.service.CarRentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class CarRentalController {

    private CarRentalService carRentalService;

    @GetMapping("/")
    public String loadStartPage() {
        return "index.html";
    }

    @GetMapping("/cars")
    public String loadAvailableCars(Model model,
                                    @RequestParam(name = "startDate") LocalDate startDate,
                                    @RequestParam(name = "endDate") LocalDate endDate) {
        CarDtoList carDtoList = null;

        carDtoList = carRentalService.getAvailableCarsForChosenPeriod(startDate, endDate);

        model.addAttribute("carDtoList", carDtoList);

        return "cars.html";
    }
}
