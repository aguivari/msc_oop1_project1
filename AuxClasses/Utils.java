package AuxClasses;
// Class with auxiliary functions to calculate averages among N patients

import java.nio.file.*;

import BaseClasses.Patient;

public class Utils {
    // function use LVTI to accept any number of patients
    public static double averageHeigth(Patient... patients) {
        if (patients.length > 0) {
            double aux = 0;
            for (Patient patient : patients) {
                aux += patient.getHeight();
            }
            aux = (double) Math.round(aux / patients.length * 100) / 100;
            return aux;
        } else {
            return 0;
        }
    }

    // function use LVTI to accept any number of patients
    public static double averageWeigth(Patient... patients) {
        if (patients.length > 0) {
            double aux = 0;
            for (Patient patient : patients) {
                aux += patient.getWeight();
            }
            aux = (double) Math.round(aux / patients.length * 100) / 100;
            return aux;
        } else {
            return 0;
        }
    }

    // function use LVTI to accept any number of patients
    public static double averageAbdCirc(Patient... patients) {
        if (patients.length > 0) {
            double aux = 0;
            for (Patient patient : patients) {
                aux += patient.getAbdCirc();
            }
            aux = aux / patients.length;
            return round2digits(aux);
        } else {
            return 0;
        }
    }

    public static double round2digits(double argument) {
        return ((double) Math.round(argument * 100) / 100);
    }

    // implemented using NIO2 methods
    public static Boolean checkFile(String fileName) {
        Path file = Paths.get(fileName);
        Files.exists(file);
        if (Files.exists(file) && Files.isRegularFile(file)) {
            return true;
        } else {
            return false;
        }
    }
}
