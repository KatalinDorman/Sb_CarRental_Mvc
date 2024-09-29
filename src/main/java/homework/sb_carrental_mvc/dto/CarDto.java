package homework.sb_carrental_mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarDto {

    private int id;
    private String type;
    private boolean available;
    private int price;
}
