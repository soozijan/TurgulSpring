package com.example.demo;

public class Utils_java {

    public static boolean checkHighwayLegalspeed(int speed) {
        if (speed > 120) {
            System.out.println("המהירות לא חוקית");

            return false;
        }

        else {
            return true;
        }
    }


        public static boolean checkUrbanLegalSpeed(int speed){
            if (speed > 90) {
                System.out.println("המהירות לא חוקית");
                return false;
            }
            else {
                return true;
            }


        }
    }


