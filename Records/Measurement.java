package Records;

import java.io.Serializable;

import  BaseClasses.Consultant;
import  BaseClasses.Patient;
import Enums.DateFormat;
import  BaseClasses.Date;

public record Measurement  (
     Patient patient, 
     Consultant consultant,
     Date measurementDate,
     double height,
     double weight,
     double circunference) implements Serializable {

        @Override
        public String toString() {
            String message="";

            message += "Measurement date: "+ this.measurementDate.getFullDoB(DateFormat.DMY);
            message += "\nMeasurement for patient: "+ this.patient.getName()+" "+this.patient.getSurname();
            message += "\nMeasurement by consultant: "+ this.consultant.getName()+" "+this.consultant.getSurname();
            message += "\nMeasurements: Height: "+ this.height()+", Weight: "+this.weight()+", Abdominal Circunference: "+this.circunference();
            
            return message;
        }

}
