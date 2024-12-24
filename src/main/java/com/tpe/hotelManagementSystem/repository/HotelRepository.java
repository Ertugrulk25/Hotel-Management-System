package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelRepository {
    // room guest ve reservation için service ve repo classları oluşturun :ÖDEV !!!!

    private Session session;


    public void save(Hotel hotel) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(hotel);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }


    }

    public Hotel findById(Long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            //trs oluşturmuyoruz çunkü fetch işleminde ihtiyaç yok


            return session.get(Hotel.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    // 3-c
    public List<Hotel> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("FROM Hotel", Hotel.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Hotel deletedHotel) {
try {


 session = HibernateUtils.getSessionFactory().openSession();
 Transaction trs = session.beginTransaction();

 session.delete(deletedHotel);

 trs.commit();

}catch (Exception e){
    System.out.println(e.getMessage());
}finally {
    HibernateUtils.closeSession(session);
}
    }
// 7-c
    public void update(Hotel foundHotel) {
    try {


        session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();

        session.update(foundHotel);

        trs.commit();
    }catch (Exception e){
        System.out.println(e.getMessage());
    }finally {
        HibernateUtils.closeSession(session);
    }
    }
}












