package com.tpe.hotelManagementSystem.service;


import com.tpe.hotelManagementSystem.domain.Hotel;
import com.tpe.hotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.hotelManagementSystem.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {
    private Scanner scanner = new Scanner(System.in);

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    // 1 c save hotel

    public void saveHotel() {
        Hotel hotel = new Hotel();

        System.out.println("Enter Hotel ID : ");
        Long id=scanner.nextLong();//todo: hali hazırda zaten bu idye sahip varsa kontrolu yapılcak
        scanner.nextLine();
        // Hotel foundHotel=findHotelById(id);
        // if (foundHotel!=null){
        //     System.out.println("Hotel save is Failed!!!!");
        // }else {
        hotel.setId(id);
        System.out.println("Enter Hotel Name : ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter Hotel Location ");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.save(hotel);

        System.out.println("Hotel is saved successfully. Hotel ID: "+hotel.getId());
//    }
    }

    //2-b : idsi verilen hotelin yazdırılma işlemi.
    public Hotel findHotelById(Long id) {
        Hotel foundHotel = hotelRepository.findById(id); // hotelRepository.findHotelId(id)
        try {
            if (foundHotel != null) {
                System.out.println("---------------------");
                System.out.println(foundHotel);
                System.out.println("----------------------");
                return foundHotel;
            } else {
                throw new HotelNotFoundException("Hotel not found by ID: ");
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void getAllHotels() {

        List<Hotel> allHotels = hotelRepository.findAll();
        if (allHotels.isEmpty()) {
            System.out.println("Hotel list is EMPTY!!! ");

        } else {
            System.out.println("------- ALL HOTELS ------------");
            for (Hotel hotel : allHotels) {
                System.out.println(hotel);
            }
            System.out.println("------- ALL HOTELS --------");

        }
    }

    public void deleteHotelById(Long deletedHotelId) {
        // id si verilne oel var mı?

        Hotel deletedHotel = findHotelById(deletedHotelId);
        if (deletedHotel != null) {
            System.out.println(deletedHotel);
            System.out.println("Are you sure to delete: ");
            System.out.println("Please answer with Y or N : ");
            String select = scanner.next();

            if (select.equalsIgnoreCase("Y")) {
                hotelRepository.delete(deletedHotel);
                System.out.println("Delete operation is Succesfully ");
            } else {
                System.out.println("Delete operation is canceled!!!");
            }


        } else {
            System.out.println("Delete operation is Canceled!!! ");
        }

    }

    // 7-b
    public void updateHotelById(Long updateHotelId) {
        //böyle bir otel var mı

        Hotel foundHotel = findHotelById(updateHotelId);

        if (foundHotel != null) {
            System.out.println("Enter the new hotel name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the new location");
            String location = scanner.nextLine();
            System.out.println("Are you sure to update: ");
            System.out.println("Please answer with Y or N : ");
            String select = scanner.next();
            if (select.equalsIgnoreCase("Y")) {
                foundHotel.setName(name);
                foundHotel.setLocation(location);
                hotelRepository.update(foundHotel);
            } else {
                System.out.println("Update operation is canceled!!! ");
            }

        } else {
            System.out.println("Update operation is canceled!!! ");
        }
    }
}











