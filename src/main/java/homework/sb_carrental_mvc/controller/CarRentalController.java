package homework.sb_carrental_mvc.controller;

import homework.sb_carrental_mvc.service.CarRentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class CarRentalController {

    private CarRentalService carRentalService;

    @GetMapping("/")
    public String loadStartPage(){
        return "index.html";
    }
}
