package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.domain.Reservation;
import com.tpe.hotelManagementSystem.domain.Room;
import com.tpe.hotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.hotelManagementSystem.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
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

        System.out.println("Enter check-in date : (yyyy-MM-dd)");//2024-12-25
        String checkIn = scanner.nextLine();
        reservation.setCheckInDate(LocalDate.parse(checkIn));

        System.out.println("Enter check-out date : (yyyy-MM-dd)");//todo düzenlenicek
        String checkOut = scanner.nextLine();
        reservation.setCheckOutDate(LocalDate.parse(checkOut));//2025-01-01

        System.out.println("Enter the room id : ");//307 fakat boyle bir oda yok
        Long roomId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the guest id : ");
        Long guestId = scanner.nextLong();
        scanner.nextLine();
        Room room = roomService.findRoomById(roomId);
        Guest guest = guestService.findGuesById(guestId);
        if (room != null && guest != null) {
            reservation.setRoom(room);
            reservation.setGuest(guest);

            reservationRepository.save(reservation);
            System.out.println("Reservation is created successfully....");
        } else {
            System.out.println("Reservation is CANCELED!!!!");
        }

    }

    public Reservation findReservationById(Long reservationId) {
        try {
            Reservation foundReservation = reservationRepository.findById(reservationId);
            if (foundReservation != null) {
                System.out.println("---------------------------------");
                System.out.println(foundReservation);
                System.out.println("---------------------------------");
                return foundReservation;
            } else {
                throw new RoomNotFoundException(" Reservation  not found with ID: " + reservationId);
            }
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void getAllReservation() {

        List<Reservation> reservations = reservationRepository.findAll();
        if (!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        } else {
            System.out.println("No rooms found!");
        }
    }

    public void deleteReservationById(Long deleteReservationlId) {

        Reservation deleteReservation = findReservationById(deleteReservationlId);
        if (deleteReservation != null) {
            System.out.println(deleteReservationlId);
            System.out.println("Are you sure to delete: ");
            System.out.println("Please answer with Y or N : ");
            String select = scanner.next();

            if (select.equalsIgnoreCase("Y")) {
                reservationRepository.delete(deleteReservation);
                System.out.println("Delete operation is Succesfully ");
            } else {
                System.out.println("Delete operation is canceled!!!");
            }


        } else {
            System.out.println("Delete operation is Canceled!!! ");
        }

    }
}


