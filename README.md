# Repository for Java application for Class Project - OOP1

## Course: [MSc in Software Design With Artificial Intelligence](https://tus.ie/courses/msc-in-software-design-with-artificial-intelligence/)
## personal github: [aguivari/msc_oop1_project1](https://github.com/aguivari/msc_oop1_project1)
## TUS github Mirror: [tussoftwaredesign/ca-aguivari](https://github.com/tussoftwaredesign/ca-aguivari/)

## Application: Simple Health Collector Application for Basic Biomedical information

## Project File & Directory Structure:
```
+Project
+--AuxClasses/          ->> Auxiliary Classes used by the applications
+--BaseClasses/         ->> Base Classes used by the applications
+--Enums/               ->> Base Eunumerations used by the applications
+--Interfaces/          ->> Interfaces used by the applications
+--Records/             ->> Records used by the applications
+--TestApplications/    ->> Applications for testing the various parts of the code
+--files/               ->> binary files used to testing objects read & write to/from disk
+--HealthCollector.java ->> Main application
+--Makefile             ->> Makefile for easy handling of compilation & clean up
+--mirrorgit.sh         ->> script to mirror personal & TUS git repos
\--README.md            ->> This file
```

#### This project will me regularly mirrored between this personal GIT repo and the repo provided by TUS

## Main Entities definition skeleton:

### Enums

#### Contract Type
````
enum ContractType {
    PERMANENT("Permanent"),
    TEMPORARY("Temporary"),
    UNDEFINED("Undefined");
}
````

#### DateFormat
````
enum DateFormat {
    DMY("DMY"),
    YMD("YMD"),
    MDY("MDY");
}
````

#### Speciality
````
enum Speciality {
    NUTRITION("Nutrition"),
    ENDOCHRINOLOGY("Endochrinology"),
    PHYSIOTHERAPY("Physiotherapy"),
    GENERALPRACTICE("General Practice"),
    PAEDIATRICIAN("Paediatrician"),
    UNDEFINED("Undefined");
}
````

#### Gender
````
enum gender {
    MALE("Male"),
    FEMALE("Female"),
    UNDEFINED("Undefined");
}
````

### Records

#### Measurements
````
record Measurement (
    Patient patient,
    Consultant consultant,
    Date measurementDate,
    double height,
    double weight,
    double circunference)
````

### Classes

#### Person
```
class Person {
    private String name;
    private String surname;
    private int dob;
    private int mob;
    private int yob;
    private Gender gender;
}
```

#### Patient
```
class Patient extends Person {
    private static int basePatientNo=0;
    private int patientNo;
    private double height;
    private double weight;
    private double circunference;
}
```

#### Consultant
```
class Consultant extends Person {
    private static int baseConsultantNo=0;
    private int consultantNo;
    private Speciality speciality;
    private ContractType contractType;
}
```

#### Date
```
class Date {
    private int day;
    private int month;
    private int year;
}
```

## Included programs

### HealthCollector (CLI)

Includes a command line / text program to use the main interfaces
with basic operations like adding patients, consultants and measumenres
and some database operations, like save, restore, etc.