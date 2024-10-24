package AuxClasses;
// Class with auxiliary functions to calculate averages among N patients
// functions use LVTI to accept any number of patients

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;

import BaseClasses.Consultant;
import BaseClasses.Patient;
import BaseClasses.Person;
import Enums.DateFormat;

public class Utils {

    //return full date from Person class type (or descendants) in specified format
    public static String getFullDoB(Person person, DateFormat format){
        String sdob=String.format("%02d", person.getDoB());
        String smob=String.format("%02d", person.getMoB());
        String syob=String.format("%04d", person.getYoB());
        return switch (format) {
            case DateFormat.DMY   -> sdob+"-"+smob+"-"+syob;
            case DateFormat.YMD   -> syob+"-"+smob+"-"+sdob;
            case DateFormat.MDY   -> smob+"-"+sdob+"-"+syob;
            default -> "Undefined";
        };
    }

    //return person class type (or descentant class) age in years
    public static String getAge(Person person)   
    {  
        LocalDate today = LocalDate.now();  
        LocalDate birth = LocalDate.parse(getFullDoB(person, DateFormat.YMD));
        
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
            System.out.print(getFullDoB(patient, DateFormat.DMY)+",");
            System.out.print(getAge(patient)+",");
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
            System.out.print(consultant.getConsultantNo()+",");
            System.out.print(consultant.getName()+",");
            System.out.print(consultant.getSurname()+",");
            System.out.print(getFullDoB(consultant, DateFormat.DMY)+",");
            System.out.print(getAge(consultant)+",");
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

    public static int getMaxPatientNo(ArrayList<Patient> patients) {
        int maxPatientNo=0;
        for (Patient patient: patients) {
            if (patient.getPatientNo()>maxPatientNo) {
                maxPatientNo=patient.getPatientNo();
            }
        }
        return maxPatientNo;
    }

    public static int getMaxConsultantNo(ArrayList<Consultant> consultants) {
        int maxConsultantNo=0;
        for (Consultant consultant: consultants) {
            if (consultant.getConsultantNo()>maxConsultantNo) {
                maxConsultantNo=consultant.getConsultantNo();
            }
        }
        return maxConsultantNo;
    }

}
