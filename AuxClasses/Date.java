package AuxClasses;
import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;

import Enums.DateFormat;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    //empty constructor gets "today" as default date
    public Date() {
        this(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year ;
    }

    //assessor methods
    // get day of the date
    public int getDay() {
        return this.day;
    }
    // get month of the date
    public int getMonth() {
        return this.month;
    }
    // get year of the date
    public int getYear() {
        return this.year;
    }

    //mutator methods
    // set day of the date
    public void setDay(int argument) {
        this.day=argument;
    }
    // set month of the date
    public void setMonth(int argument) {
        this.month=argument;
    }
    // set year of the date
    public void setYear(int argument) {
        this.year=argument;
    }

    //return full date in specified format
    public String getFullDate(DateFormat format){
        String sdob=String.format("%02d", this.day);
        String smob=String.format("%02d", this.month);
        String syob=String.format("%04d", this.year);
        return switch (format) {
            case DateFormat.DMY -> sdob+"-"+smob+"-"+syob;
            case DateFormat.YMD -> syob+"-"+smob+"-"+sdob;
            case DateFormat.MDY -> smob+"-"+sdob+"-"+syob;
            default -> "Undefined";
        };
    }
    //return date age in years, months, days
    public String getDateAge() {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse(this.getFullDate(DateFormat.YMD));

        if ((birth != null) && (today != null)) {
            Period age=Period.between(birth, today);
            String message="";
            if (age.getYears()>1) {
                message+=age.getYears()+" Years ";
            } else if (age.getYears()==1) {
                message+=age.getYears()+" Year ";
            }
            if (age.getMonths()>1) {
                message+=age.getMonths()+" Months ";
            } else if (age.getMonths()==1) {
                message+=age.getMonths()+" Month ";
            }
            if (age.getDays()>1) {
                message+=age.getDays()+" Days";
            } else if (age.getDays()==1) {
                message+=age.getDays()+" Day";
            }
            return message;
        } else {
            return "Error getting age";
        }
    }
}
