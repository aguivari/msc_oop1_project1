package BaseClasses;

import java.util.ResourceBundle;
import java.util.Locale;

import AuxClasses.Utils;
import Enums.Gender;
public final class Patient extends Person implements Comparable<Patient> {
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
    public Patient(String patientName,
                   String patientSurname,
                   int patientDoB,
                   int patientMoB,
                   int patientYoB,
                   Gender patientGender) {
        this(patientName,patientSurname,patientDoB,patientMoB,patientYoB,patientGender, 0, 0, 0);
     }

    //Constructor with all parameters , using super() to to base Person class
    public Patient(String patientName,
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

    //copy constructor
    public Patient(Patient p) {
        this(p.getName(), p.getSurname(), p.getBirthDay(), p.getBirthMonth(), p.getBirthYear(), p.getGender(), p.getHeight(), p.getWeight(), p.getAbdCirc());
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
    public void setWeight(double argument) {
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
    //calculate CMI
    public double getCMI() {
        if ((this.weight>0) && (this.height>0)) {
            double cmi=this.weight*1E4/(this.height*this.height);
            return Utils.round2digits(cmi);
        } else {
            return -1;
        }
    }
    //provide IMC health classification
    public String getCMIClass() {
        String message;
        double cmi=getCMI();
        if (cmi<0) { //error in CMI calculation
            message="Undefined CMI, undefined classification";
        } else if (cmi < 17 ) {
            message="Very underweight";
        } else if (cmi < 18.5 ) {
            message="Underweight";
        } else if (cmi < 25 ) {
            message="Normal weight";
        } else if (cmi < 30 ) {
            message="Overweight";
        } else if (cmi < 35 ) {
            message="Grade I Obesity";
        } else if (cmi < 40 ) {
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
        StringBuilder sb = new StringBuilder();
        ResourceBundle patientResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());

        sb.append(patientResourceBundle.getString("PatientId")).append(": ").append(this.patientNo);
        sb.append(super.toString());
        sb.append("\n").append(patientResourceBundle.getString("PatientHeight"));
        sb.append(": ").append(this.height).append(" cm");
        sb.append("\n").append(patientResourceBundle.getString("PatientWeight"));
        sb.append(": ").append(this.weight).append(" Kg");
        sb.append("\n").append(patientResourceBundle.getString("PatientCMI"));
        sb.append(": ").append(this.getCMI());
        sb.append("\n").append(patientResourceBundle.getString("PatientCMIClass"));
        sb.append(": ").append(this.getCMIClass());
        sb.append("\n").append(patientResourceBundle.getString("PatientAbdCirc"));
        sb.append(": ").append(this.circunference);
        sb.append("\n").append(patientResourceBundle.getString("PatientAbdCircRiskClass"));
        sb.append(": ").append(getAbdCircRisk()).append("\n");
        return sb.toString();
    }

    public int compareTo(Patient p) {
        return this.getWeight() > p.getWeight() ? 1 : 
               this.getWeight() < p.getWeight() ? -1 : 0;
    }

    public static int compareWeight(Patient lhs, Patient rhs) {
        if (lhs.getWeight() > rhs.getWeight())
            return 1;
        if (lhs.getWeight() < rhs.getWeight())
            return -1;
        return 0;
    }
  
    public static int compareHeight(Patient lhs, Patient rhs) {
        if (lhs.getHeight() > rhs.getHeight())
            return 1;
        if (lhs.getHeight() < rhs.getHeight())
            return -1;
        return 0;
    }
  
    public static int compareAbdCirc(Patient lhs, Patient rhs) {
        if (lhs.getAbdCirc() > rhs.getAbdCirc())
            return 1;
        if (lhs.getAbdCirc() < rhs.getAbdCirc())
            return -1;
        return 0;
    }



}