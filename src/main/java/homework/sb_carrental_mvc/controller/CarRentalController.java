package homework.sb_carrental_mvc.controller;

import homework.sb_carrental_mvc.dto.CarDtoList;
import homework.sb_carrental_mvc.dto.ReservationDto;
import homework.sb_carrental_mvc.service.CarRentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

        CarDtoList carDtoList = carRentalService.getAvailableCarsForChosenPeriod(startDate, endDate);

        model.addAttribute("carDtoList", carDtoList);

        return "cars.html";
    }

    @GetMapping("/cars/startres")
    public String startReservation(Model model,
                                   @RequestParam(name = "startDate") LocalDate startDate,
                                   @RequestParam(name = "endDate") LocalDate endDate,
                                   @RequestParam(name = "carId") int carId) {

        ReservationDto reservationDto = carRentalService.prepareReservationDto(startDate, endDate, carId);

        model.addAttribute("reservationDto", reservationDto);

        return "reservation.html";
    }

    @PostMapping("/cars/endres")
    public String endReservation(Model model,
                                 @RequestParam(name = "carId") int carId,
                                 @RequestParam(name = "startDate") LocalDate startDate,
                                 @RequestParam(name = "endDate") LocalDate endDate,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "address") String address,
                                 @RequestParam(name = "phone") String phone) {

        ReservationDto reservationDto = carRentalService.getReservationDto(carId, startDate, endDate, name, email,
                address, phone);

        model.addAttribute("reservationDto", reservationDto);

        return "result.html";
    }
}
