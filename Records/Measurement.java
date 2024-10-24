package Records;

import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  BaseClasses.Date;
import  Enums.DateFormat;

public class Measurement {
    private static int measurementBaseNo;
    private int measurementNo;
    private Patient patientRef;
    private Consultant consultantRef;
    private Date measurementDate;    
}
