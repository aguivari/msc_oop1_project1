package Interfaces;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import BaseClasses.Consultant;
import Enums.Speciality;

public final class ConsultantAPI implements ConsultantAPIDefinitions {
    private ArrayList<Consultant> consultantList;
    private static ReentrantLock lock = new ReentrantLock();;

    public ConsultantAPI() {
        consultantList = new ArrayList<>();
    }

    public void trim() {
        lock.lock();
        try {
            consultantList.clear();
        } finally {
            lock.unlock();
        }

    };

    public int getSize() {
        lock.lock();
        try {
            return this.consultantList.size();
        } finally {
            lock.unlock();
        }

    };

    public void add(Consultant consultant) {
        lock.lock();
        try {
            consultantList.add(consultant);
        } finally {
            lock.unlock();
        }

    }

    public ArrayList<Consultant> getAll() {
        lock.lock();
        try {
            return new ArrayList<Consultant>(consultantList);
        } finally {
            lock.unlock();
        }

    }

    public Map<Speciality, Long> getConsultantCountBySpecialty() {
        lock.lock();
        try {
            Map<Speciality, Long> consultantCountBySpeciality = consultantList
                    .stream()
                    .collect(Collectors.groupingBy(Consultant::getSpeciality,
                            Collectors.counting()));
            return consultantCountBySpeciality;
        } finally {
            lock.unlock();
        }

    }

    public long getConsultantCountBySpecialty(Speciality argument) {
        lock.lock();
        try {
            long consultantCountBySpeciality = consultantList
                    .stream()
                    .filter(c -> c.getSpeciality() == argument)
                    .count();
            return consultantCountBySpeciality;
        } finally {
            lock.unlock();
        }

    }

    public Map<Integer, String> getConsultantMap() {
        lock.lock();
        try {
            Map<Integer, String> getConsultantMap = consultantList.stream()
                    .collect(Collectors.toMap(Consultant::getConsultantNo, Consultant::getName));
            return getConsultantMap;
        } finally {
            lock.unlock();
        }

    }

    public Consultant getLast() {
        lock.lock();
        try {
            return new Consultant(consultantList.get(consultantList.size() - 1));
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
                writeStream.writeObject(this.consultantList);
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
            ResourceBundle consultantAPIResourceBundle = ResourceBundle.getBundle("HealthCollector",
                    Locale.getDefault());
            var tempList = new ArrayList<Consultant>();

            try {
                FileInputStream readData = new FileInputStream(filename);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                try {
                    tempList = (ArrayList<Consultant>) readStream.readObject();
                } catch (EOFException e) {
                    System.out.println(consultantAPIResourceBundle.getString("ErrorEOF"));
                }
                readStream.close();
                for (Consultant consultant : tempList) {
                    this.add(consultant);
                }
                int max = getMaxIndex();
                System.out.println(consultantAPIResourceBundle.getString("ResetBaseConsultantNo") + " " + max);
                this.consultantList.get(0).resetBaseConsultantNo(max);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }

    }

    private int getMaxIndex() {
        lock.lock();
        try {
            int maxIndex = 0;
            for (Consultant consultant : this.consultantList) {
                if (consultant.getConsultantNo() > maxIndex) {
                    maxIndex = consultant.getConsultantNo();
                }
            }
            return maxIndex;
        } finally {
            lock.unlock();
        }

    }

    public void dumpConsultantCSV() {
        lock.lock();
        try {
            // generates CSV list of patients
            // print header
            System.out.println("Consultant Number,Name,Surname,DoB,Age,Gender,Speciality,Contract Type");
            for (Consultant consultant : this.consultantList) {
                System.out.print(consultant.getConsultantNo() + ",");
                System.out.print(consultant.getName() + ",");
                System.out.print(consultant.getSurname() + ",");
                System.out.print(consultant.getFullDate() + ",");
                System.out.print(consultant.getAge() + ",");
                System.out.print(consultant.getGender().label + ",");
                System.out.print(consultant.getSpeciality() + ",");
                System.out.println(consultant.getContractType());
            }
        } finally {
            lock.unlock();
        }

    }
}
