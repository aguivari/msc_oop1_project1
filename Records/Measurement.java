package Records;

import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import  BaseClasses.Date;

public record Measurement (
     Patient patient, 
     Consultant consultant,
     Date measurementDate,
     double height,
     double weight,
     double circunference)
     {


     }
