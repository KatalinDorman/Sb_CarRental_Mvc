package homework.sb_carrental_mvc.dto;

import java.time.LocalDate;

public class ReservationDto {

    private CarDto carDto;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private String email;
    private String address;
    private String phone;
    private int fullPrice;

    public ReservationDto(CarDto carDto, LocalDate startDate, LocalDate endDate, String name, String email,
                          String address, String phone, int fullPrice) {
        this.carDto = carDto;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.fullPrice = fullPrice;
    }
}
