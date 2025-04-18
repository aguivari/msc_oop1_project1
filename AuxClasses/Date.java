package AuxClasses;

import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import Enums.DateFormat;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    // empty constructor gets "today" as default date
    public Date() {
        this(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getYear());
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // copy constructor
    public Date(Date d) {
        this(d.getDay(), d.getMonth(), d.getYear());
    }

    // assessor methods
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

    // mutator methods
    // set day of the date
    public void setDay(int argument) {
        this.day = argument;
    }

    // set month of the date
    public void setMonth(int argument) {
        this.month = argument;
    }

    // set year of the date
    public void setYear(int argument) {
        this.year = argument;
    }

    // return full date in specified format
    public String getFullDate(DateFormat format) {
        String sdob = String.format("%02d", this.day);
        String smob = String.format("%02d", this.month);
        String syob = String.format("%04d", this.year);
        return switch (format) {
            case DateFormat.DMY -> sdob + "-" + smob + "-" + syob;
            case DateFormat.YMD -> syob + "-" + smob + "-" + sdob;
            case DateFormat.MDY -> smob + "-" + sdob + "-" + syob;
            default -> "Undefined";
        };
    }

    // return date age in years, months, days
    public String getDateAge() {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse(this.getFullDate(DateFormat.YMD));
        ResourceBundle dateResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());

        if ((birth != null) && (today != null)) {
            Period age = Period.between(birth, today);
            String message = "";
            if (age.getYears() > 1) {
                message += age.getYears() + " " + dateResourceBundle.getString("Years") + " ";
            } else if (age.getYears() == 1) {
                message += age.getYears() + " " + dateResourceBundle.getString("Year" + " ");
            }
            if (age.getMonths() > 1) {
                message += age.getMonths() + " " + dateResourceBundle.getString("Months") + " ";
            } else if (age.getMonths() == 1) {
                message += age.getMonths() + " " + dateResourceBundle.getString("Month") + " ";
            }
            if (age.getDays() > 1) {
                message += age.getDays() + " " + dateResourceBundle.getString("Days");
            } else if (age.getDays() == 1) {
                message += age.getDays() + " " + dateResourceBundle.getString("Day");
            }
            return message;
        } else {
            return dateResourceBundle.getString("ErrorGettingAge");
        }
    }
}
