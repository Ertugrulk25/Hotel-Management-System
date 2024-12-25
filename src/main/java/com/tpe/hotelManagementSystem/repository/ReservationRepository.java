package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationRepository {
    private Session session;

    public void save(Reservation reservation) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(reservation);
            trs.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Reservation findById(Long reservationId) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Reservation reservation = session.get(Reservation.class, reservationId);

            return reservation;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);

        }
        return null;
    }

    public List<Reservation> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Reservation> reservations = session.createQuery("FROM Reservation", Reservation.class).getResultList();
            return reservations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Reservation deleteReservation) {

        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.delete(deleteReservation);

            trs.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}