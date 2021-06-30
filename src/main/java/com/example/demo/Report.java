package com.example.demo;

import java.io.Serializable;


public class Report  implements Serializable {

        private int id;
        private String License_Plate;
        private int Driver_Id;
        private int Speed;


        public Report() {

        }

        public Report(int id) {
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLicense_Plate(String License_Plate) {
            this.License_Plate = License_Plate;
        }

        public void setDriver_Id(int address) {
            this.Driver_Id = Driver_Id;
        }
        public void setSpeed(int Speed) {
        this.Driver_Id = Driver_Id;
    }




        public String getLicense_Plate() {
            return License_Plate;
        }

        public int getDriver_Id() {
            return Driver_Id;
        }

        public int getSpeed() {
            return Speed;
        }


        public int getId() { return id;}

        public Report(int id, String License_Plate, int Driver_Id, int Speed ) {
            this.id = id;
            this.License_Plate = License_Plate;
            this.Driver_Id = Driver_Id;
            this.Speed = Speed;

        }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", License_Plate='" + License_Plate + '\'' +
                ", Driver_Id=" + Driver_Id +
                ", Speed=" + Speed +
                '}';
    }


}





