package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.hotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.hotelManagementSystem.model.Hotel;
import com.tpe.hotelManagementSystem.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository implements Repository<Room,Long>{
    @Override
    public Room save(Room object) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(object);
            trs.commit();
            session.close();
            return object;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            HibernateUtils.shutDown();
        }
    }

    @Override
    public Room findObjectById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Room.class,id);
    }

    @Override
    public void update(Room object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();

        Room existingRoom = session.get(Room.class, object.getId());
        if (existingRoom != null) {
            existingRoom.setNumber(object.getNumber());
            existingRoom.setCapacity(object.getCapacity());

            session.update(existingRoom);
        }
        trs.commit();
        session.close();
    }
    @Override
    public void deleteById(Long id) throws HotelNotFoundException, RoomNotFoundException {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Room roomlToDelete=session.get(Room.class,id);
        if (roomlToDelete!=null){
            session.delete(roomlToDelete);
            trs.commit();
        }else{
            throw new RoomNotFoundException("Room not found with Id : "+id);
        }

    }



    @Override
    public List<Room> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("from Room", Room.class).getResultList();
    }
}
