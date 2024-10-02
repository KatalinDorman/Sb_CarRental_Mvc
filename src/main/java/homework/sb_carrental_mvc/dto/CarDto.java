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
    private boolean newCarSaved;

    public CarDto(Integer id, String type, boolean available, int price) {
        this.id = id;
        this.type = type;
        this.available = available;
        this.price = price;
    }
}
