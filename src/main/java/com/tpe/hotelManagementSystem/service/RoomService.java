package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.hotelManagementSystem.repository.RoomRepository;

import java.util.List;
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
        try {
            Room room = new Room();
            System.out.println("Enter room ID: ");
            room.setId(scanner.nextLong());
            scanner.nextLine();
            System.out.println("Enter room Number: ");
            room.setNumber(scanner.next());
            System.out.println("Enter room capacity");
            room.setCapacity(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter Hotel ID: ");
            Long hotelId = scanner.nextLong();
            scanner.nextLine();

//id si verilen oteli bulma


            Hotel hotel = hotelService.findHotelById(hotelId);
            if (hotel != null) {
                room.setHotel(hotel);

                roomRepository.save(room);
                System.out.println("Room is saved succesfully " + room.getId());
            } else {
                System.out.println("Room could not saved!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //5-b : Id si verilen odayı tablodan bulup yazdırma ve geri döndürme:ÖDEV
    public Room findRoomById(Long roomId) {
        try {
            Room foundRoom = roomRepository.findById(roomId);
            if (foundRoom != null) {
                System.out.println("---------------------------------");
                System.out.println(foundRoom);
                System.out.println("---------------------------------");
                return foundRoom;
            } else {
                throw new RoomNotFoundException(" Room  not found with ID: " + roomId);
            }
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //6-b: eğer tablo boş değilse tüm odaları listeleme:ÖDEV
    public void getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        if (!rooms.isEmpty()) {
            for (Room room : rooms) {
                System.out.println(room);
            }
        } else {
            System.out.println("No rooms found!");
        }
    }

    public void deleteRoomlById(Long deleteRoomlId) {

        Room deletedRoom = findRoomById(deleteRoomlId);
        if (deletedRoom != null) {
            System.out.println(deletedRoom);
            System.out.println("Are you sure to delete: ");
            System.out.println("Please answer with Y or N : ");
            String select = scanner.next();

            if (select.equalsIgnoreCase("Y")) {
                roomRepository.delete(deletedRoom);
                System.out.println("Delete operation is Succesfully ");
            } else {
                System.out.println("Delete operation is canceled!!!");
            }


        } else {
            System.out.println("Delete operation is Canceled!!! ");
        }

    }
    }

