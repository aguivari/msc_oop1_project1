// Class with auxiliary functions to calculate averages among N patients
// functions use LVTI to accept any number of patients

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

    public static void dumpPatientsCSV(ArrayList <Patient> patients) {
        //generates CSV list of patients
        //print header
        System.out.println("Patient Number,Name,Surname,DoB,Age,Gender,Heigth,Weigth,Abdominal Circunference,IMC,IMC Classification,Abdominal Risk Classification");
        for (Patient patient: patients) {
            System.out.print(patient.getPatientNo()+",");
            System.out.print(patient.getName()+",");
            System.out.print(patient.getSurname()+",");
            System.out.print(patient.getFullDoB(DateFormat.DMY)+",");
            System.out.print(patient.getAge()+",");
            System.out.print(patient.getGender().label+",");
            System.out.print(patient.getHeight()+",");
            System.out.print(patient.getWeight()+",");
            System.out.print(patient.getIMC()+",");
            System.out.print(patient.getIMCClass()+",");
            System.out.print(patient.getAbdCirc()+",");
            System.out.println(patient.getAbdCircRisk());
        }
    }

    public static void dumpConsultantCSV(ArrayList <Consultant> consultants) {
        //generates CSV list of patients
        //print header
        System.out.println("Consultant Number,Name,Surname,DoB,Age,Gender,Speciality,Contract Type");
        for (Consultant consultant: consultants) {
            System.out.print(consultant.getconsultantNo()+",");
            System.out.print(consultant.getName()+",");
            System.out.print(consultant.getSurname()+",");
            System.out.print(consultant.getFullDoB(DateFormat.DMY)+",");
            System.out.print(consultant.getAge()+",");
            System.out.print(consultant.getGender().label+",");
            System.out.print(consultant.getSpeciality()+",");
            System.out.println(consultant.getContractType());
            
        }
    }

    public static void writePatientsToDisk(String filename, ArrayList <Patient> patients)  {
        //write list of patients to file patients.bin
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(patients);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeConsultantsToDisk(String filename, ArrayList <Consultant> consultants)  {
        //write list of patients to file patients.bin
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(consultants);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList <Patient> readPatientsFromDisk(String filename) {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            
            try {
                
                    patients= (ArrayList<Patient>)readStream.readObject();
                
            } catch (EOFException e) {
                // End of stream
                System.out.println("reached end of file");
            } 
            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static ArrayList <Consultant> readConsultantsFromDisk(String filename)  {
        ArrayList<Consultant> consultants = new ArrayList<Consultant>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            try {
                consultants= (ArrayList<Consultant>)readStream.readObject();
            } catch (EOFException e) {
                // End of stream
                System.out.println("reached end of file");
            } 
            readStream.close();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return consultants;
    }




}
