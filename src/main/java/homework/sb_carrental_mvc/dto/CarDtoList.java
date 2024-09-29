package homework.sb_carrental_mvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CarDtoList {

    private List<CarDto> carDtoList;
    private LocalDate startDate;
    private LocalDate endDate;

    public CarDtoList(List<CarDto> carDtoList, LocalDate startDate, LocalDate endDate) {
        this.carDtoList = carDtoList;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CarDtoList() {
    }
}
