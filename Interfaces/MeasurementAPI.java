package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Records.Measurement;
import AuxClasses.Date;

public class MeasurementAPI implements MeasurementAPIDefinitions {
    private ArrayList<Measurement> measurementList;

    public MeasurementAPI() {
        measurementList = new ArrayList<Measurement>();
    }

    public void trim() {
        measurementList.clear();

    };
   
    public int getSize() {
        return this.measurementList.size();
    };

    public void add(Measurement measurement) {
        measurementList.add(measurement);
    }

    public ArrayList<Measurement> getAll() {
        return measurementList;
    }

    public Measurement getLast() {
        return measurementList.get(measurementList.size()-1);
    }

    public ArrayList<Measurement> getAllByDate(Date argument) {
        ArrayList<Measurement> tempList = new ArrayList<Measurement>();
        for (Measurement measurement: measurementList) {
            if (measurement.measurementDate() == argument) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public ArrayList<Measurement> getAllByConsultant(int argument) {
        ArrayList<Measurement> tempList = new ArrayList<Measurement>();
        for (Measurement measurement: measurementList) {
            if (measurement.consultant().getConsultantNo() == argument) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public ArrayList<Measurement> getAllByPatient(int argument) {
        ArrayList<Measurement> tempList = new ArrayList<Measurement>();
        for (Measurement measurement: measurementList) {
            if (measurement.patient().getPatientNo() == argument) {
                tempList.add(measurement);
            }
        }
        return tempList;
    }

    public void writeToDisk(String filename) {
        try{
            FileOutputStream writeData = new FileOutputStream(filename);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(this.measurementList);
            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void readFromDisk(String filename) {
        this.trim();
        ArrayList<Measurement> tempList = new ArrayList<Measurement>();
        try{
            FileInputStream readData = new FileInputStream(filename);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            try {
                tempList = (ArrayList<Measurement>)readStream.readObject();
            } catch (EOFException e) {
                System.out.println("error: reached end of file");
            }
            readStream.close();
            for (Measurement measurement: tempList) {
                this.add(measurement);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
