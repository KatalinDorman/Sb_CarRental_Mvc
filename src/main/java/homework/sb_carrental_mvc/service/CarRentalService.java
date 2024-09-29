package homework.sb_carrental_mvc.service;

import homework.sb_carrental_mvc.db.Database;
import homework.sb_carrental_mvc.dto.CarDto;
import homework.sb_carrental_mvc.dto.CarDtoList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CarRentalService {

    private Database db;

    public CarDtoList getAvailableCarsForChosenPeriod(LocalDate startDate, LocalDate endDate) {
        CarDtoList carDtoList = new CarDtoList();
        List<CarDto> availableCarDtoList = null;

        availableCarDtoList = db.getAvailableCarDtos(startDate, endDate);

        carDtoList.setCarDtoList(availableCarDtoList);
        carDtoList.setStartDate(startDate);
        carDtoList.setEndDate(endDate);

        return carDtoList;
    }
}
