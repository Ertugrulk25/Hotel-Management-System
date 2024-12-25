package com.tpe.hotelManagementSystem.config;


//import com.tpe.hotelManagementSystem.Try;
import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Reservation;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml").
                    addAnnotatedClass(Guest.class)
                    .addAnnotatedClass(Reservation.class)
                    .addAnnotatedClass(Room.class).
                    addAnnotatedClass(Hotel.class);
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //getter
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //sf kapatalım
    public static void shutDown() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            getSessionFactory().close();
        }
        }
        //session kapatma icin
        public static void closeSession (Session session){
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }