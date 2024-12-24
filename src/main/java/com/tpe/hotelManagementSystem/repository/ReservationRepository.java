package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepository {
   private Session session;

    public void save(Reservation reservation) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(reservation);
            trs.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}
