package AuxClasses;
// Class with auxiliary functions to calculate averages among N patients
// functions use LVTI to accept any number of patients

import java.time.LocalDate;
import java.time.Period;

import BaseClasses.Patient;
import BaseClasses.Person;
import Enums.DateFormat;

public class Utils {

    //return full date from Person class type (or descendants like Patient or Consultant) in specified format
    public static String getFullDate(Person person, DateFormat format){
        String sdob=String.format("%02d", person.getDoB());
        String smob=String.format("%02d", person.getMoB());
        String syob=String.format("%04d", person.getYoB());
        return switch (format) {
            case DateFormat.DMY -> sdob+"-"+smob+"-"+syob;
            case DateFormat.YMD -> syob+"-"+smob+"-"+sdob;
            case DateFormat.MDY -> smob+"-"+sdob+"-"+syob;
            default -> "Undefined";
        };
    }

    //return person class type (or descendants like Patient or Consultant) age in years, months, days
    public static String getAge(Person person)
    {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse(getFullDate(person, DateFormat.YMD));

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

    public static double averageHeigth(Patient... patients) {
        if (patients.length>0) {
            double aux=0;
            for (Patient patient: patients) {
                aux+=patient.getHeight();
            }
            aux=(double)Math.round(aux/patients.length*100)/100;
            return aux;
        } else {
            return 0;
        }
    }

    public static double averageWeigth(Patient... patients) {
        if (patients.length>0) {
            double aux=0;
            for (Patient patient: patients) {
                aux+=patient.getWeight();
            }
            aux=(double)Math.round(aux/patients.length*100)/100;
            return aux;
        } else {
            return 0;
        }
    }

    public static double averageAbdCirc(Patient... patients) {
        if (patients.length>0) {
            double aux=0;
            for (Patient patient: patients) {
                aux+=patient.getAbdCirc();
            }
            aux=aux/patients.length;
            return round2digits(aux);
        } else {
            return 0;
        }
    }

    public static double round2digits(double argument) {
        return ((double)Math.round(argument*100)/100);
    }
}
