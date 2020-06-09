
package printer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    private int hours, minutes, seconds;
    private String Meridian;

    public Time() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        this.hours = now.getHour();
        this.minutes = now.getMinute();
        this.seconds = now.getSecond();
    }

    public Time(int hour, int minute, int second) {
        this.hours = hour;
        this.minutes = minute;
        this.seconds = second;
    }

    public String getMeridian() {
        return Meridian;
    }

    public void setMeridian(String Meridian) {
        this.Meridian = Meridian;
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

    public void convertto12() {
        if (hours > 12 && hours < 24) {
            setMeridian("PM");
           /* switch (getHours()) {
                case 13: {
                    hours =01;
                    break;
                }
                case 14: {
                    hours =2;
                    break;
                }
                case 15: {
                    hours =3;
                    break;
                }
                case 16: {
                    hours =4;
                    break;
                }
                case 17: {
                    hours =5;
                    break;
                }
                case 18: {
                    hours =6;
                    break;
                }
                case 19: {
                    hours =7;
                    break;
                }
                case 20: {
                    hours =8;
                    break;
                }
                case 21: {
                    hours =9;
                    break;
                }
                case 22: {
                    hours =10;
                    break;
                }
                case 23: {
                    hours =11;
                    break;
                }case 24: {
                    hours =0;
                    break;
                }
            }*/
        } else {
            setMeridian("AM");

        }

    }

    public String TimeDisplay() {
        //convertto12();
        return (String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds));
    }

}
