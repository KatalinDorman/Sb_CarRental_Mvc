package homework.sb_carrental_mvc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdminDto {

    private List<ReservationDto> reservationDtoList;
    private List<CarDto> carDtoList;

    public AdminDto(List<ReservationDto> reservationDtoList, List<CarDto> carDtoList) {
        this.reservationDtoList = reservationDtoList;
        this.carDtoList = carDtoList;
    }
}
