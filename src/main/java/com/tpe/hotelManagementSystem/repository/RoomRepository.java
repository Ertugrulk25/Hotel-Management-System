package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository {

    private Session session;
    public void save(Room room) {
  try {


      session = HibernateUtils.getSessionFactory().openSession();
      Transaction trs = session.beginTransaction();
      session.save(room);
      trs.commit();
  }catch (Exception e){
    e.printStackTrace();
  }finally {
      HibernateUtils.closeSession(session);
  }
   }
    public Room findById(Long roomId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Room room=session.get(Room.class, roomId);
            return room;
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
    //6-c
    public List<Room> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Room> rooms = session.createQuery("FROM Room", Room.class).getResultList();
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Room deletedRoom) {
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.delete(deletedRoom);

            trs.commit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    }