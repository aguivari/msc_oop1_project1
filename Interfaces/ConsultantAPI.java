package Interfaces;

import java.util.ArrayList;
import java.util.stream.*;
import java.util.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import BaseClasses.Consultant;
import Enums.Speciality;

public final class ConsultantAPI implements ConsultantAPIDefinitions {
    private ArrayList<Consultant> consultantList;

    public ConsultantAPI() {
        consultantList = new ArrayList<>();
    }

    public void trim() {
        consultantList.clear();

    };
   
    public int getSize() {
        return this.consultantList.size();
    };

    public void add(Consultant consultant) {
        consultantList.add(consultant);
    }

    public ArrayList<Consultant> getAll() {
        return new ArrayList<Consultant>(consultantList);
    }

    public Map<Speciality, Long> getConsultantCountBySpecialty() {   
        Map<Speciality, Long> consultantCountBySpeciality = consultantList
            .stream()
            .collect(Collectors.groupingBy(Consultant::getSpeciality,
                     Collectors.counting()));
        return consultantCountBySpeciality;
    }

    public long getConsultantCountBySpecialty(Speciality argument) {   
        long  consultantCountBySpeciality = consultantList
            .stream()
            .filter(c -> c.getSpeciality() == argument)
            .count();
        return consultantCountBySpeciality;
    }

    public Consultant getLast() {
        return new Consultant(consultantList.get(consultantList.size()-1));
    }

    public void writeToDisk(String filename) {
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(this.consultantList);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void readFromDisk(String filename) {
        this.trim();
        ResourceBundle consultantAPIResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());
        var tempList = new ArrayList<Consultant>();

        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Consultant>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println(consultantAPIResourceBundle.getString("ErrorEOF"));
            }
            readStream.close();
            for (Consultant consultant: tempList) {
                this.add(consultant);
            }
            int max=getMaxIndex();
            System.out.println(consultantAPIResourceBundle.getString("ResetBaseConsultantNo")+" "+max);
            this.consultantList.get(0).resetBaseConsultantNo(max);


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getMaxIndex() {
        int maxIndex=0;
        for (Consultant consultant: this.consultantList) {
            if (consultant.getConsultantNo()>maxIndex) {
                maxIndex=consultant.getConsultantNo();
            }
        }
        return maxIndex;
    }

    public void dumpConsultantCSV() {
        //generates CSV list of patients
        //print header
        System.out.println("Consultant Number,Name,Surname,DoB,Age,Gender,Speciality,Contract Type");
        for (Consultant consultant: this.consultantList) {
            System.out.print(consultant.getConsultantNo()+",");
            System.out.print(consultant.getName()+",");
            System.out.print(consultant.getSurname()+",");
            System.out.print(consultant.getFullDate()+",");
            System.out.print(consultant.getAge()+",");
            System.out.print(consultant.getGender().label+",");
            System.out.print(consultant.getSpeciality()+",");
            System.out.println(consultant.getContractType());
        }
    }
}
