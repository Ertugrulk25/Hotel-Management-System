package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.repository.RoomRepository;

import java.util.Scanner;

// entitynin service class ları kendi repo classları ile iletişiime geçer.
public class RoomService {
private Scanner scanner = new Scanner(System.in);

private final RoomRepository roomRepository;

private final HotelService hotelService;

    public RoomService(RoomRepository roomRepository,HotelService hotelService) {
        this.roomRepository = roomRepository;
       this.hotelService = hotelService;

    }
//4 a 2 alınan bilgilerle odayı kaydetme
    public void saveRoom() {
        Room room =new Room();
        System.out.println("Enter room ID: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Enter room Number: ");
        room.setNumber(scanner.next());
        System.out.println("Enter room capacity");
        room.setCapacity(scanner.nextInt());
        System.out.println("Enter Hote: ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();
//id si verilen oteli bulma


        Hotel hotel = hotelService.findHotelById(hotelId));
        if (hotel!= null){
            room.setHotel(hotel);

        roomRepository.save(room);
            System.out.println("Room is saved succesfully "+ room.getId());
        }else {
            System.out.println("Room could not saved!!!");
        }








    }
}
