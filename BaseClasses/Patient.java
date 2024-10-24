package BaseClasses;

import AuxClasses.Utils;
import Enums.Gender;

public class Patient extends Person {
    private static int basePatientNo=0;
    private int patientNo;
    private double height;
    private double weight;
    private double circunference;

    //Constructors
    //Constructor with no parameter, using this()
    public Patient() {
        this("","",1,1,1,Gender.UNDEFINED, 0, 0, 0);
    }

     //Constructor with some parameters, using this()
    public Patient( String patientName, 
                    String patientSurname, 
                    int patientDoB,
                    int patientMoB,
                    int patientYoB,
                    Gender patientGender) {
        this(patientName,patientSurname,patientDoB,patientMoB,patientYoB,patientGender, 0, 0, 0);
     }

    //Constructor with all parameters , using super() to to base Person class
    public Patient( String patientName, 
                    String patientSurname, 
                    int patientDoB,
                    int patientMoB,
                    int patientYoB,
                    Gender patientGender, 
                    double patientHeight, 
                    double patienteWeight, 
                    double patientCircunference) {
        super(patientName,patientSurname,patientDoB,patientMoB,patientYoB,patientGender);
        incrementBasePatientNo();
        this.patientNo=basePatientNo;
        this.height=patientHeight;
        this.weight=patienteWeight;
        this.circunference=patientCircunference;
    }
    
    private void incrementBasePatientNo() {
        basePatientNo++;
    }

    //Mutator methods
    //set patient Height
    public void setHeight(double argument) {
        this.height = argument;
    }
    //set patient Weight
    public void setWeith(double argument) {
        this.weight = argument;
    }
    //set patient abdominal circunference
    public void setAbdCirc(double argument) {
        this.circunference = argument;
    }

    //Assessor methods
    //assess Patient Id
    public int getPatientNo(){
        return this.patientNo;
    }
    //assess Patient Height
    public double getHeight(){
        return this.height;
    }
    //assess Patient Weight
    public double getWeight(){
        return this.weight;
    }

    //assess Patient abdominal circunference
    public double getAbdCirc(){
        return this.circunference;
    }

    //Calculation methods
    //calculate IMC
    public double getIMC() {
        if ((this.weight>0) && (this.height>0)) {
            double imc=this.weight*1E4/(this.height*this.height);
            return Utils.round2digits(imc);
        } else {
            return -1;
        }
    }
    //provide IMC health classification
    public String getIMCClass() {
        String message;
        double imc=getIMC();
        if (imc<0) { //error in IMC calculation
            message="Undefined IMC, undefined classification";
        } else if (imc < 17 ) {
            message="Very underweight";
        } else if (imc < 18.5 ) {
            message="Underweight";
        } else if (imc < 25 ) {
            message="Normal weight";
        } else if (imc < 30 ) {
            message="Overweight";
        } else if (imc < 35 ) {
            message="Grade I Obesity";
        } else if (imc < 40 ) {
            message="Grade II Obesity";
        } else {
            message="Grade III Obesity";        
        }
        return message;
    }

    //provide Abdominal Circunderence health classification
    public String getAbdCircRisk() {
        String message;
        switch (super.getGender()) {
        case Gender.MALE: //male        
            if (this.circunference < 90 ) {
                message="Normal risk";
            }
            else if (this.circunference < 94 ) {
                message="Average risk";
            }
            else if (this.circunference < 102 ) {
                message="High risk";
            }
            else {
                message="Very high risk";        
            }
            break;
        case Gender.FEMALE: //female        
            if (this.circunference < 80 ) {
                message="Normal risk";
            }
            else if (this.circunference < 84 ) {
                message="Average risk";
            }
            else if (this.circunference < 88 ) {
                message="High risk";
            }
            else {
                message="Very high risk";
            }
            break;
        default: //calculation not define for now
            message="Error, calculation not defined for parameters";
            break;
        }
        return message;
    }   

    //allows for setting the basePatientNo in case reading from file.
    public void resetBasePatientNo(int argument) {
        basePatientNo=argument;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="Patient Id: "+patientNo;
        message=message+super.toString();
        message=message+"\nPatient Height: "+height;
        message=message+"\nPatient Weight: "+weight;
        message=message+"\nPatient Abdominal Circunference: "+circunference;
        
        return message;
    }
}