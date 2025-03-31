package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;

import Records.Measurement;
import BaseClasses.Consultant;
import BaseClasses.Patient;

import AuxClasses.Date;

public final class MeasurementAPI implements MeasurementAPIDefinitions {
    private ArrayList<Measurement> measurementList;
    private static ReentrantLock lock = new ReentrantLock();;

    public MeasurementAPI() {
        measurementList = new ArrayList<>();
    }

    public void trim() {
        lock.lock();
        try {
            measurementList.clear();
        } finally {
            lock.unlock();
        }
    };

    public int getSize() {
        lock.lock();
        try {
            return this.measurementList.size();
        } finally {
            lock.unlock();
        }
    };

    public void add(Measurement measurement) {
        lock.lock();
        try {
            measurementList.add(measurement);
            // update Patient with new measurements
            measurement.patient().setHeight(measurement.height());
            measurement.patient().setWeight(measurement.weight());
            measurement.patient().setAbdCirc(measurement.circunference());
        } finally {
            lock.unlock();
        }
    }

    public Measurement getLast() {
        lock.lock();
        try {
            return new Measurement(measurementList.get(measurementList.size() - 1));
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Measurement> getAll() {
        lock.lock();
        try {
            return new ArrayList<Measurement>(measurementList);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Measurement> getAll(Date argument) {
        lock.lock();
        try {
            var tempList = new ArrayList<Measurement>();
            for (Measurement measurement : measurementList) {
                if (measurement.measurementDate() == argument) {
                    tempList.add(measurement);
                }
            }
            return tempList;
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Measurement> getAll(Consultant argument) {
        lock.lock();
        try {
            ArrayList<Measurement> tempList = new ArrayList<>();
            for (Measurement measurement : measurementList) {
                if (measurement.consultant().getConsultantNo() == argument.getConsultantNo()) {
                    tempList.add(measurement);
                }
            }
            return tempList;
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Measurement> getAll(Patient argument) {
        lock.lock();
        try {
            ArrayList<Measurement> tempList = new ArrayList<>();
            for (Measurement measurement : measurementList) {
                if (measurement.patient().getPatientNo() == argument.getPatientNo()) {
                    tempList.add(measurement);
                }
            }
            return tempList;
        } finally {
            lock.unlock();
        }
    }

    public void writeToDisk(String filename) {
        lock.lock();
        try {
            try {
                FileOutputStream writeData = new FileOutputStream(filename);
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
                writeStream.writeObject(this.measurementList);
                writeStream.flush();
                writeStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public void readFromDisk(String filename) {
        lock.lock();
        try {
            this.trim();
            ResourceBundle measurementAPIResourceBundle = ResourceBundle.getBundle("HealthCollector",
                    Locale.getDefault());
            ArrayList<Measurement> tempList = new ArrayList<>();
            try {
                FileInputStream readData = new FileInputStream(filename);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                try {
                    tempList = (ArrayList<Measurement>) readStream.readObject();
                } catch (EOFException e) {
                    System.out.println(measurementAPIResourceBundle.getString("ErrorEOF"));
                }
                readStream.close();
                for (Measurement measurement : tempList) {
                    this.add(measurement);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

}
