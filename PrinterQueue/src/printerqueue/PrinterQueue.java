/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printerqueue;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author F2018266327
 */
public class PrinterQueue {

    /**
     * @param args the command line arguments
     */
    public static class TimeDate {

        private int date, year, hours, minutes, seconds;
        private String day, month;

        public TimeDate() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.date = now.getDayOfMonth();
            this.month = now.getMonth().toString();
            this.year = now.getYear();
            this.hours = now.getHour();
            this.minutes = now.getMinute();
            this.seconds = now.getSecond();
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }
        @Override
        public String toString()
        {
            
            return String.valueOf(getYear())+" "+getMonth()+" "+ String.valueOf(getDate())+" " +getDay()+" "+ String.valueOf(getHours())+" "+ String.valueOf(getMinutes())+" "+ String.valueOf(getSeconds());
        }
    }

    class job {

        private int NumberOFpages;
        private TimeDate submittedTime;
        
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);
         TimeDate  n=new TimeDate();
     
        System.out.println("date : " + n.getDate());
        System.out.println("month : " + n.getMonth());
        System.out.println("year : " + n.getYear());
        System.out.println("hour : " + n.getHours());
        System.out.println("mint : " + n.getMinutes());
        System.out.println("second : " + n.getSeconds());

    }

}
