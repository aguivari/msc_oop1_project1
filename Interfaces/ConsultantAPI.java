package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import BaseClasses.Consultant;

public class ConsultantAPI implements ConsultantAPIDefinitions {
    private ArrayList<Consultant> consultantList;

    public ConsultantAPI() {
        consultantList = new ArrayList<Consultant>();
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
        return consultantList;
    }

    public Consultant getLast() {
        return consultantList.get(consultantList.size()-1);
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

    public void readFromDisk(String filename) {
        this.trim();
        ArrayList<Consultant> tempList = new ArrayList<Consultant>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Consultant>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println("error: reached end of file");
            }
            readStream.close();
            for (Consultant consultant: tempList) {
                this.add(consultant);
            }
            int max=getMaxIndex();
            System.out.println("Resetting baseConsultantNo to "+max);
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

}
