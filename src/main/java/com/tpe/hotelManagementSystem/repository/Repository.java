package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.hotelManagementSystem.exception.RoomNotFoundException;

import java.util.List;

//crud işlemleerini yapan bir depo
public interface Repository <S,U> {

    //create işlemi
    S save(S object);
    //read işlemi
    S findObjectById(U id);
    //update işlemi
    void update(S object);
    //delete
    void deleteById(U id) throws HotelNotFoundException, RoomNotFoundException;
    //tüm değerleri listeyelen method
    List<S> findAll();


}
