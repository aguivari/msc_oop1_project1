package BaseClasses;
import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;

import Enums.DateFormat;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date() {
        this(1,1,1);
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
    public void getDay(int argument) {
        this.day=argument;
    }
    // set month of the date
    public void getMonth(int argument) {
        this.month=argument;
    }
    // set year of the date
    public void getYear(int argument) {
        this.year=argument;
    }
    
    //return full date in specified format
    public String getFullDoB(DateFormat format){
        String sdob=String.format("%02d", this.day);
        String smob=String.format("%02d", this.month);
        String syob=String.format("%04d", this.year);
        return switch (format) {
            case DateFormat.DMY   -> sdob+"-"+smob+"-"+syob;
            case DateFormat.YMD   -> syob+"-"+smob+"-"+sdob;
            case DateFormat.MDY   -> smob+"-"+sdob+"-"+syob;
            default -> "Undefined";
        };
    }
    //return date age in years, months, days
    public String getAge()   
    {  
        LocalDate today = LocalDate.now();  
        LocalDate birth = LocalDate.parse(this.getFullDoB(DateFormat.YMD));
        
        if ((birth != null) && (today != null)) {  
            Period age=Period.between(birth, today);
            String message="";
            if (age.getYears()>0) {
                message+=age.getYears()+" Years ";
            }
            if (age.getMonths()>0) {
                message+=age.getMonths()+" Months ";
            }
            if (age.getDays()>0) {
                message+=age.getDays()+" Days";
            }
            return message;

        } else {  
            return "Error getting age";  
        }  
    }    
}
