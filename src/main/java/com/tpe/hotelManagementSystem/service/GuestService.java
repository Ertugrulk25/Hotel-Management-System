package com.tpe.hotelManagementSystem.service;

import com.tpe.hotelManagementSystem.domain.Address;
import com.tpe.hotelManagementSystem.domain.Guest;
import com.tpe.hotelManagementSystem.exception.GuestNotFoundException;
import com.tpe.hotelManagementSystem.repository.GuestRepository;

import java.util.Scanner;

public class GuestService {
    //9 b
    private Scanner scanner = new Scanner(System.in);
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public void saveGuest( ) {
        Guest guest = new Guest();

        System.out.println("Enter the name : ");
        guest.setName(scanner.nextLine());
        Address address =new Address();
        System.out.println("Enter the Street:");
        address.setStreet(scanner.nextLine());
        System.out.println("Enter the City:");
        address.setCity(scanner.nextLine());
        System.out.println("Enter the Country:");
        address.setCountry(scanner.nextLine());
        System.out.println("Enter the Zipcode:");
        address.setZipcode(scanner.nextLine());

        guest.setAddress(address);
        guestRepository.save(guest);
        System.out.println("Guest is saved Successfully....");
    }
//ödev
    public Guest findGuesById(Long guestId) {
  try {
      Guest foundGuest = guestRepository.findById(guestId);
      if (foundGuest!= null) {
          System.out.println("-----------------------------");
          System.out.println(foundGuest);
          System.out.println("-------------------------------");
          return foundGuest;
      }else {
          throw new GuestNotFoundException("Guest not found by ID: "+ guestId);
      }
  }catch (GuestNotFoundException e){//exceptionu ayarla
      System.out.println(e.getMessage());
  }


    }
}





