package homework.sb_carrental_mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class AdminDto {

    private List<ReservationDto> reservationDtoList;
    private List<CarDto> carDtoList;
}
