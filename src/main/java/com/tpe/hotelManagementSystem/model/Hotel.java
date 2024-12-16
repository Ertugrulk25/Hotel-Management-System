
package com.tpe.hotelManagementSystem.model;

//2.adım Hotel isimli bir class olusturduk ve bu class entegre edebilmek icin Entity ve Table anatasyonlarını kullandık

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
    @Table(name = "tbl_hotels")
    public class Hotel {

        //3. adım primary key yani id olusturalım
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)//id degerinin otomatik olarak artmasını saglar
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private String location;

        @OneToMany
        private List<Room> rooms=new ArrayList();

        //5.adım değer atamasını kolaylastırmak icin const

        public Hotel(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public Hotel() {
        }

        //4.adım degerlere erisebilmek icin getter-setter


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Long getId() {
            return id;

        }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
        public String toString() {
            return "Hotel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
