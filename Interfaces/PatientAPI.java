package Interfaces;

import java.util.ArrayList;
import java.util.stream.Collectors;

import AuxClasses.Utils;

import java.util.Comparator;
import java.util.Optional;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.concurrent.locks.ReentrantLock;

import BaseClasses.Patient;

public final class PatientAPI implements PatientAPIDefinitions {
    private ArrayList<Patient> patientList;
    private static ReentrantLock lock = new ReentrantLock();;

    public PatientAPI() {
        patientList = new ArrayList<>();
    }

    public void trim() {
        lock.lock();
        try {
            patientList.clear();
        } finally {
            lock.unlock();
        }
    };

    public int getSize() {
        lock.lock();
        try {
            return this.patientList.size();
        } finally {
            lock.unlock();
        }

    };

    public void add(Patient patient) {
        lock.lock();
        try {
            patientList.add(patient);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Patient> getAll() {
        lock.lock();
        try {
            return new ArrayList<Patient>(patientList);
        } finally {
            lock.unlock();
        }
    }

    public Patient getLast() {
        lock.lock();
        try {
            // return defensive copy of patient
            return new Patient(patientList.get(patientList.size() - 1));
        } finally {
            lock.unlock();
        }
    }

    public Patient getMinWeightPatient() {
        lock.lock();
        try {
            return patientList
                    .stream()
                    .min(Comparator.comparing(Patient::getWeight))
                    .orElseThrow(NoSuchElementException::new);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Patient> getMinWeightPatient(int n) {
        lock.lock();
        try {
            return new ArrayList<Patient>(patientList
                    .stream()
                    .sorted(Patient::compareWeight)
                    .limit(n)
                    .collect(Collectors.toList()));
        } finally {
            lock.unlock();
        }
    }

    public Patient getMaxWeightPatient() {
        lock.lock();
        try {
            return patientList
                    .stream()
                    .max(Comparator.comparing(Patient::getWeight))
                    .orElseThrow(NoSuchElementException::new);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Patient> getMaxWeightPatient(int n) {
        lock.lock();
        try {
            return new ArrayList<Patient>(patientList
                    .stream()
                    .sorted(Patient::compareWeight)
                    .limit(n)
                    .collect(Collectors.toList()));
        } finally {
            lock.unlock();
        }
    }

    public Patient getMinHeightPatient() {
        lock.lock();
        try {
            return patientList
                    .stream()
                    .min(Comparator.comparing(Patient::getHeight))
                    .orElseThrow(NoSuchElementException::new);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Patient> getMinHeightPatient(int n) {
        lock.lock();
        try {
            return new ArrayList<Patient>(patientList
                    .stream()
                    .sorted(Patient::compareHeight)
                    .limit(n)
                    .collect(Collectors.toList()));
        } finally {
            lock.unlock();
        }
    }

    public Patient getMaxHeightPatient() {
        lock.lock();
        try {
            return patientList
                    .stream()
                    .max(Comparator.comparing(Patient::getHeight))
                    .orElseThrow(NoSuchElementException::new);
        } finally {
            lock.unlock();
        }
    }

    public ArrayList<Patient> getMaxHeightPatient(int n) {
        lock.lock();
        try {
            return new ArrayList<Patient>(patientList
                    .stream()
                    .sorted(Patient::compareHeight)
                    .limit(n)
                    .collect(Collectors.toList()));
        } finally {
            lock.unlock();
        }
    }

    public long getPatientCountBySurname(String argument) {
        lock.lock();
        try {
            long patientCountBySurname = patientList
                    .stream()
                    .filter(c -> c.getSurname() == argument)
                    .count();
            return patientCountBySurname;
        } finally {
            lock.unlock();
        }
    }

    public Map<String, Long> getPatientCountBySurname() {
        lock.lock();
        try {
            Map<String, Long> patientCountBySurname = patientList
                    .stream()
                    .collect(Collectors.groupingBy(Patient::getSurname,
                            Collectors.counting()));
            return patientCountBySurname;
        } finally {
            lock.unlock();
        }
    }

    public Long getPatientCountBornFrom(int year) {
        lock.lock();
        try {
            Long patientCountBySurname = patientList
                    .stream()
                    .collect(Collectors.partitioningBy(p -> p.getBirthYear() >= year, Collectors.counting()))
                    .get(true);

            return patientCountBySurname;
        } finally {
            lock.unlock();
        }
    }

    public Long getPatientCountBefore(int year) {
        lock.lock();
        try {
            Long patientCountBySurname = patientList
                    .stream()
                    .collect(Collectors.partitioningBy(p -> p.getBirthYear() < year, Collectors.counting()))
                    .get(true);
            return patientCountBySurname;
        } finally {
            lock.unlock();
        }
    }

    public Optional<Patient> getAnyPatient() {
        lock.lock();
        try {
            Optional<Patient> patient = patientList
                    .stream()
                    .findAny();
            if (patient.isPresent()) {
                return patient;
            } else
                return null;
        } finally {
            lock.unlock();
        }
    }

    public double getAverageWeight() {
        lock.lock();
        try {
            double avgWeightent = patientList
                    .stream()
                    .mapToDouble(Patient::getWeight)
                    .average()
                    .orElse(0.0);
            return avgWeightent;
        } finally {
            lock.unlock();
        }
    }

    public double getAverageHeight() {
        lock.lock();
        try {
            double avgWeightent = patientList
                    .stream()
                    .mapToDouble(Patient::getHeight)
                    .average()
                    .orElse(0.0);
            return avgWeightent;
        } finally {
            lock.unlock();
        }
    }

    public Optional<Patient> getFirstPatient() {
        lock.lock();
        try {
            Optional<Patient> patient = patientList
                    .stream()
                    .findFirst();
            if (patient.isPresent()) {
                return patient;
            } else
                return null;

        } finally {
            lock.unlock();
        }
    }

    public boolean areAllPatientsBornBefore(int year) {
        lock.lock();
        try {
            boolean result = patientList
                    .stream()
                    .allMatch((p -> p.getBirthYear() < year));
            return result;
        } finally {
            lock.unlock();
        }
    }

    public boolean areAnyPatientsBornBefore(int year) {
        lock.lock();
        try {
            boolean result = patientList
                    .stream()
                    .anyMatch((p -> p.getBirthYear() < year));
            return result;
        } finally {
            lock.unlock();
        }
    }

    public boolean areNoPatientsBornBefore(int year) {
        lock.lock();
        try {
            boolean result = patientList
                    .stream()
                    .noneMatch((p -> p.getBirthYear() < year));
            return result;
        } finally {
            lock.unlock();
        }
    }

    public void dumpPatients() {
        lock.lock();
        try {
            patientList
                    .stream()
                    .forEach(patient -> System.out.println(patient));
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
                writeStream.writeObject(this.patientList);
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
            ResourceBundle patientAPIResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());
            var tempList = new ArrayList<Patient>();
            try {
                if (!Utils.checkFile(filename)) {
                    System.out.println(patientAPIResourceBundle.getString("ErrorNotFound"));
                    return;
                }
                this.trim();
                FileInputStream readData = new FileInputStream(filename);
                ObjectInputStream readStream = new ObjectInputStream(readData);
                try {
                    tempList = (ArrayList<Patient>) readStream.readObject();
                } catch (EOFException e) {
                    System.out.println(patientAPIResourceBundle.getString("ErrorEOF"));
                }
                readStream.close();
                for (Patient patient : tempList) {
                    this.add(patient);
                }
                int max = getMaxIndex();
                System.out.println(patientAPIResourceBundle.getString("ResetBasePatientNo") + " " + max);
                patientList.get(0).resetBasePatientNo(max);

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
            for (Patient patient : this.patientList) {
                if (patient.getPatientNo() > maxIndex) {
                    maxIndex = patient.getPatientNo();
                }
            }
            return maxIndex;
        } finally {
            lock.unlock();
        }
    }

    public void dumpCSV() {
        lock.lock();
        try {
            // generates CSV list of patients
            // print header
            System.out.println(
                    "Patient Number,Name,Surname,DoB,Age,Gender,Heigth,Weigth,Abdominal Circunference,IMC,IMC Classification,Abdominal Risk Classification");
            for (Patient patient : this.patientList) {
                System.out.print(patient.getPatientNo() + ",");
                System.out.print(patient.getName() + ",");
                System.out.print(patient.getSurname() + ",");
                System.out.print(patient.getFullDate() + ",");
                System.out.print(patient.getAge() + ",");
                System.out.print(patient.getGender().label + ",");
                System.out.print(patient.getHeight() + ",");
                System.out.print(patient.getWeight() + ",");
                System.out.print(patient.getCMI() + ",");
                System.out.print(patient.getCMIClass() + ",");
                System.out.print(patient.getAbdCirc() + ",");
                System.out.println(patient.getAbdCircRisk());
            }
        } finally {
            lock.unlock();
        }
    }

}
