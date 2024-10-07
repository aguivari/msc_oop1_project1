# Repository for Java application for Class Project - OOP1

## Course: [MSc in Software Design With Artificial Intelligence](https://tus.ie/courses/msc-in-software-design-with-artificial-intelligence/)
## gitHub: [aguivari/msc_oop1_project1](https://github.com/aguivari/msc_oop1_project1)


## Application: Simple Patient Tracker for Basic Biomedical information

## Class definition skeleton:
```
Class Patient {
    private static int basePatientNo=0;
    private int patientNo;
    private String name;
    private String surname;
    private int gender;
    private double height;
    private double weight;
    private double circunference;

  //No-parameters Construtor
  
  //Full-parameters Construtor
  
  //Mutator Methods

  //Assessor Methods

  //Auxiliary Methods
}
```

## Included programs

### PatientTesterCLI 

Includes a command line / text program to use the Patient class
with basic operations like added, editing and removing patients
and some database operations, like save, restore, etc.

### PatientTesterGUI

Includes a JavaFX GUI program to use the Patient class
with basic operations like added, editing and removing patients
and some database operations, like save, restore, etc.