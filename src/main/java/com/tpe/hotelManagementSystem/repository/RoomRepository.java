package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.domain.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
