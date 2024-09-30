package homework.sb_carrental_mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CarDto {

    private Integer id;
    private String type;
    private boolean available;
    private int price;
}
