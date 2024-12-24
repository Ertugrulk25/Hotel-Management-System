package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepository {

   private Session session;


   //9-c
    public void save(Guest guest) {
        try{
        session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        session.saveOrUpdate(guest);//kayıt yoksa save eder var ise update eder update de id değişmez.

        trs.commit();
    } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
        HibernateUtils.closeSession(session);

        }
    }
//ödev2 c
    public Guest findById(Long guestId) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
           Guest guest =  session.get(Guest.class,guestId);
    return guest;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);

        }


    }
}
