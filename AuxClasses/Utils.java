package AuxClasses;
// Class with auxiliary functions to calculate averages among N patients
// functions use LVTI to accept any number of patients


import BaseClasses.Patient;

public class Utils {

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
