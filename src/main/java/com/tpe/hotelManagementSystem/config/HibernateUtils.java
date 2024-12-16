package com.tpe.hotelManagementSystem.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    //1. adım sessionFactory'i etkinleştirmem lazım
    private static SessionFactory sessionFactory;//okunabilir bir değer
    static { //
        try {
            Configuration config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();
        }catch (Exception e){
            System.out.println("Session factory build edilirken bir sorunla karşılaşıldı : "+e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutDown(){
        getSessionFactory().close();
    }

}