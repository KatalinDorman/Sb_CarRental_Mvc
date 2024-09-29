package homework.sb_carrental_mvc.db;

import homework.sb_carrental_mvc.dto.CarDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class Database {

    SessionFactory sessionFactory;

    public Database() {
        Configuration cfg = new Configuration();
        cfg.configure();

        sessionFactory = cfg.buildSessionFactory();
    }

    public List<CarDto> getAvailableCarDtos(LocalDate startDate, LocalDate endDate) {
        List<CarDto> carDtos = null;

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery(
                """
                        SELECT c
                        FROM Car c
                        WHERE c.available = ?1
                        AND c.id NOT IN
                            (SELECT r.carId  FROM Reservation r)
                        OR c.id IN
                            (SELECT r.carId
                            FROM Reservation r
                            WHERE r.carId NOT IN
                                (SELECT r.carId
                                 FROM Reservation r
                                 WHERE (?2 BETWEEN r.startDate AND r.endDate)
                                 AND (?3 BETWEEN r.startDate AND r.endDate)))
                        """);
        query.setParameter(1, true);
        query.setParameter(2, startDate);
        query.setParameter(3, endDate);
        carDtos = query.getResultList();

        tx.commit();
        session.close();

        return carDtos;
    }
}
