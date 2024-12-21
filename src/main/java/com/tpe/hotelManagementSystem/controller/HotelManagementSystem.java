package com.tpe.hotelManagementSystem.controller;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.repository.HotelRepository;
import com.tpe.hotelManagementSystem.repository.RoomRepository;
import com.tpe.hotelManagementSystem.service.HotelService;
import com.tpe.hotelManagementSystem.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);


    //ana menü kullanıcıya gösterilir ve seçimi alınır.

    public static void displayHotelManagementSystemMenu() {
        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);
        RoomRepository roomRepository = new RoomRepository();
        RoomService roomService = new RoomService(roomRepository);
int choice;
do {
    System.out.println("=================== Hotel Management System ===========================");
    System.out.println("1. Hotel Operations ");
    System.out.println("2. Room Operations ");
    System.out.println("3. Guest Operations ");
    System.out.println("4. Reservation Operations ");
    System.out.println("0. EXIT ");
    System.out.println("Enter your choice: ");
    choice = scanner.nextInt();
    scanner.nextLine(); //dumppy

switch (choice){
    case 1 :
        //Hotel operations
        displayHotelOperationsMenu(hotelService);
        break;
    case 2 :
        //room operations
        displayRoomOperationsMenu(roomService);
        break;
    case 3 :
        // guest operations
        displayGuestOperationsMenu();
        break;
    case 4 :
        //reservatıon operations
        displayReservationOperationsMenu();
        break;
    case 0 :
        System.out.println("Good Bye... ");
        HibernateUtils.shutDown();

        break;
    default:
        System.out.println("Invalid Choice, Please Try Again... ");
}
}while (choice!=0);

    }
    // her bir kategori için ayrı methodlar oluşturmam gerekiyor : işlemleri gösteren
    private static void displayHotelOperationsMenu(HotelService hotelService) {
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hotelService.saveHotel();
                    break;
                case 2:
                    //2-a : Hotel Bul id ile
                    System.out.println("Enter Hotel ID : ");
                    Long id=scanner.nextLong();
                    scanner.nextLine();
                    hotelService.findHotelById(id);
                    break;
                case 3:

                    break;
                case 4:
        // tüm hotelleri listeleme
                    hotelService.getAllHotels();
                    break;
                case 5:
                // todo:  4-a: otellerin güncelleme işlemi

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService) {



        System.out.println("Room Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
            // 4-a işlemini yapabilmek için bir odaya ihtiyaç var
                    //4-a.1 oda oluşturma

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //guest operations
    private static void displayGuestOperationsMenu() {
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:

                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu() {
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }
}





