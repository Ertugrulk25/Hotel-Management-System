package com.tpe.hotelManagementSystem.config;


import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    //1. adım sessionFactory'i etkinleştirmem lazım
    private static SessionFactory sessionFactory;//okunabilir bir değer

    static {
try {
    Configuration config = new Configuration().configure().
            addAnnotatedClass(Guest.class).
            addAnnotatedClass(Readable.class).
            addAnnotatedClass(Hotel.class).
            addAnnotatedClass(Room.class);
    sessionFactory = config.buildSessionFactory();
}catch (Exception e){
    System.out.println(e.getMessage());
}
}
// getter

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //sf kapatalım
    public static void shutDown(){
        if (sessionFactory!= null && sessionFactory.isOpen()){
            getSessionFactory().close();
    }else {
            System.out.println("sessionFactory is already null or close");
        }
    }
    //sessionu kapatmak için
    public static void closeSession(Session session){
        if (session!=null && session.isOpen()){
            session.close();
        }else {
            System.out.println("sessionFactory is already null or close");
        }
    }
}











