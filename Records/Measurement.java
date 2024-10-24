package Records;

import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  BaseClasses.Date;

public class Measurement {
    private static int measurementBaseNo;
    private int measurementNo;
    private Patient patientRef;
    private Consultant consultantRef;
    private Date measurementDate;
    private double height;
    private double weight;
    private double circunference;    
}
