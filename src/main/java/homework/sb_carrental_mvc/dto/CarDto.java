package homework.sb_carrental_mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private int id;
    private String type;
    private boolean available;
    private int price;

    public CarDto(int id, String type, boolean available, int price) {
        this.id = id;
        this.type = type;
        this.available = available;
        this.price = price;
    }
}
