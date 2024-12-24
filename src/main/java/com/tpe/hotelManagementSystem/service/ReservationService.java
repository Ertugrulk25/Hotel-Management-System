package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Reservation;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationService {

    private Scanner scanner = new Scanner(System.in);

    private final ReservationRepository reservationRepository;

    private final GuestService guestService;

    private final RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository, GuestService guestService, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    public void createReservation() {

        Reservation reservation = new Reservation();

        System.out.println("Enter check-in date: (yyyy-MM-dd)");//2024-12-25
        String checkIn = scanner.nextLine();
        reservation.setCheckInDate(LocalDate.parse(checkIn));
        System.out.println("Enter check-out date: (yyyy-MM-dd)"); //todo: düzenlenecek
        String checkOut = scanner.nextLine();
        reservation.setCheckInDate(LocalDate.parse(checkOut));

        System.out.println("Enter the room ID: ");
        Long roomId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the guest ID: ");
        Long guestId = scanner.nextLong();
        scanner.nextLine();
        Room room = roomService.findRoomById(roomId);
        Guest guest = guestService.findGuesById(guestId);
        if (room!=null&&guest!=null){
            reservation.setRoom(room);
            reservation.setGuest(guest);

            reservationRepository.save(reservation);
            System.out.println("Reservation is created successfully...");
        }else {
            System.out.println("Reservation is CANCELED!!!!");

        }
    }
}



