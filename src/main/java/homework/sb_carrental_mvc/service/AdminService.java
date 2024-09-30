package homework.sb_carrental_mvc.service;

import homework.sb_carrental_mvc.db.Database;
import homework.sb_carrental_mvc.dto.AdminDto;
import homework.sb_carrental_mvc.dto.CarDto;
import homework.sb_carrental_mvc.dto.ReservationDto;
import homework.sb_carrental_mvc.model.Car;
import homework.sb_carrental_mvc.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private Database db;

    public AdminDto getAdminDto() {
        AdminDto adminDto = null;
        List<CarDto> carDtoList = new ArrayList<>();
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        List<Car> carList;
        List<Reservation> reservationList;


        carList = db.getAllCars();
        reservationList = db.getAllReservations();

        if (carList.size() > 0) {
            for (Car car : carList) {
                CarDto carDto = new CarDto(car.getId(),
                        car.getType(),
                        car.isAvailable(),
                        car.getPrice());
                carDtoList.add(carDto);
            }
            if (reservationList.size() > 0) {

                for (Reservation reservation : reservationList) {
                    CarDto carDto = getCarDtoById(reservation.getCarId());

                    ReservationDto reservationDto = new ReservationDto(reservation.getId(),
                            carDto,
                            reservation.getStartDate(),
                            reservation.getEndDate(),
                            reservation.getName(),
                            reservation.getEmail(),
                            reservation.getAddress(),
                            reservation.getPhone(),
                            reservation.getFullPrice());
                    reservationDtoList.add(reservationDto);
                }
                adminDto = new AdminDto(carDtoList, reservationDtoList);
            } else {
                adminDto = new AdminDto(carDtoList, null);
            }
        }

        return adminDto;
    }

    public CarDto getCarDtoById(int carId) {
        CarDto carDto = null;
        Car car = db.getCarById(carId);

        carDto = new CarDto(car.getId(), car.getType(), car.isAvailable(), car.getPrice());

        return carDto;
    }
}
