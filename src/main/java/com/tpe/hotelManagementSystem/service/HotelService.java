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

    public void saveHotel(){
        Hotel hotel = new Hotel();

        System.out.println("Enter hotel ID ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location ");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.save(hotel);

        System.out.println("Hotel is saved successfully. Hotel ID: "+ hotel.getId());
    }

    //2- b id si veriln otelin yazdırma işlemi
    public Hotel findHotelById(Long id) throws HotelNotFoundException {
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
       }catch (HotelNotFoundException e){
           System.out.println(e.getMessage());
       }
return null;
    }

    public void getAllHotels() {

        List<Hotel> allHotels = hotelRepository.findAll();
        if (allHotels.isEmpty()){
            System.out.println("Hotel list is EMPTY!!! ");

        }else {
            System.out.println("------- ALL HOTELS ------------");
        for (Hotel hotel : allHotels){
            System.out.println(hotel);
        }
            System.out.println("------- ALL HOTELS --------");

        }
    }
}












