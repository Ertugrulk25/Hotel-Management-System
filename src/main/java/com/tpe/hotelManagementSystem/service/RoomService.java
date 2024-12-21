package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.repository.RoomRepository;

// entitynin service class ları kendi repo classları ile iletişiime geçer.
public class RoomService {

private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
}
