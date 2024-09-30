package homework.sb_carrental_mvc.service;

import homework.sb_carrental_mvc.db.Database;
import homework.sb_carrental_mvc.dto.CarDto;
import homework.sb_carrental_mvc.dto.CarDtoList;
import homework.sb_carrental_mvc.dto.ReservationDto;
import homework.sb_carrental_mvc.model.Car;
import homework.sb_carrental_mvc.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarRentalService {

    private Database db;

    public CarDtoList getAvailableCarsForChosenPeriod(LocalDate startDate, LocalDate endDate) {
        CarDtoList carDtoList;
        List<CarDto> availableCarDtoList = new ArrayList<>();

        List<Car> availableCarList = db.getAvailableCarList(startDate, endDate);

        for (Car car : availableCarList) {
            CarDto carDto = new CarDto(car.getId(), car.getType(), car.isAvailable(), car.getPrice());
            availableCarDtoList.add(carDto);
        }

        carDtoList = new CarDtoList(availableCarDtoList, startDate, endDate);

        return carDtoList;
    }

    public CarDto getCarDtoById(int carId) {
        CarDto carDto = null;
        Car car = db.getCarById(carId);

        carDto = new CarDto(car.getId(), car.getType(), car.isAvailable(), car.getPrice());

        return carDto;
    }

    public ReservationDto getReservationDto(Integer id, CarDto carDto, LocalDate startDate, LocalDate endDate,
                                            String name, String email, String address, String phone, Integer fullPrice) {
        ReservationDto reservationDto = null;

        reservationDto = new ReservationDto(id, carDto, startDate, endDate, name, email, address, phone, fullPrice);

        return reservationDto;
    }

    public void saveReservationDto(ReservationDto reservationDto) {

        Reservation reservation = new Reservation(reservationDto.getId(),
                reservationDto.getCarDto().getId(),
                reservationDto.getName(),
                reservationDto.getEmail(),
                reservationDto.getAddress(),
                reservationDto.getPhone(),
                reservationDto.getStartDate(),
                reservationDto.getEndDate(),
                reservationDto.getFullPrice());
        db.saveNewReservation(reservation);
    }

    public int calculateFullPrice(LocalDate startDate, LocalDate endDate, int price) {
        int fullPrice = 0;
        int daysBetweenStartAndEndDate = Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate));

        fullPrice = daysBetweenStartAndEndDate * price;

        return fullPrice;
    }
}
