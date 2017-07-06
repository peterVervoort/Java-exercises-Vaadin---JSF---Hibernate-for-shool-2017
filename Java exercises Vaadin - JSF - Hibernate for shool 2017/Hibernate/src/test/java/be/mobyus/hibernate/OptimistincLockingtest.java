package be.mobyus.hibernate;

import be.mobyus.hibernate.exercise2.entities.Product;
import be.mobyus.hibernate.exercise2.entities.SeatReservation;
import be.mobyus.hibernate.exercise2.entities.StockInformation;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

//import org.springframework.util.Assert;

/**
 * Created by java on 08.03.17.
 */
@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("hibernate")
public class OptimistincLockingtest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    private void SessionFactestVersionIncrase(){
        SeatReservation seatReservation = new SeatReservation();

        sessionFactory.getCurrentSession().save(seatReservation);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();

       // seatReservation = (SeatReservation) sessionFactory.getCurrentSession().get(SeatReservation.class,);
        seatReservation.setGivenTO("John Doe");
        seatReservation.setSeatId("24F");

        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();

        //TODO...
    }



}
