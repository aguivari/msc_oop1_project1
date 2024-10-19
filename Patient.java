public class Patient extends Person {
    private static int basePatientNo=0;
    private int patientNo;
    private String name;
    private String surname;
    private int gender; // 1 = biological male, 2=biological female, 0=not defined
    private double height;
    private double weight;
    private double circunference;

    //Constructors
    //Constructor with no parameter
    public Patient() {
        incrementBasePatientNo();
        patientNo=basePatientNo;
        name="";
        surname="";
        gender=0;
        height=0;
        weight=0;
        circunference=0;
    }

    //Constructor with all parameters 
    public Patient(int patientId, 
                    String patientName, 
                    String patientSurname, 
                    int patientGender, 
                    double patientHeight, 
                    double patienteWeight, 
                    double patientCircunference) {
        incrementBasePatientNo();
        patientNo=patientId;
        name=patientName;
        surname=patientSurname;
        gender=patientGender;
        height=patientHeight;
        weight=patienteWeight;
        circunference=patientCircunference;
    }
    
    private void incrementBasePatientNo() {
        basePatientNo++;
    }

    //Mutator methods
    //set Patient Name
    public void setName(String argument) {
        name = argument;
    }
    //set Patient Surname
    public void setSurname(String argument) {
        surname = argument;
    }
    //set Patient Gender
    public void setGender(int argument) {
        gender = argument;
    }
    //set patient Height
    public void setHeight(double argument) {
        height = argument;
    }
    //set patient Weight
    public void setWeith(double argument) {
        weight = argument;
    }
    //set patient abdominal circunference
    public void setAbdCirc(double argument) {
        circunference = argument;
    }

    //Assessor methods
    //assess Patient Id
    public int getPatientNo(){
        return this.patientNo;
    }
    //assess Patient Name
    public String getName(){
        return name;
    }
    //assess Patient Surname
    public String getSurname(){
        return name;
    }
    //assess Patient gender
    public int getGender(){
        return gender;
    }
    //assess Patient Height
    public double getHeight(){
        return height;
    }
    //assess Patient Weight
    public double getWeight(){
        return weight;
    }
    //assess Patient abdominal circunference
    public double getAbdCirc(){
        return circunference;
    }

    //Calculation methods
    //calculate IMC
    public double getIMC() {
        return weight/(height*height);
    }
    //provide IMC health classification
    public String getIMCClass() {
        String message;
        double imc=getIMC();
        if (imc < 17 ) {
            message="Very underweight";
        }
        else if (imc < 18.5 ) {
            message="Underweight";
        }
        else if (imc < 25 ) {
            message="Normal weight";
        }
        else if (imc < 30 ) {
            message="Overweight";
        }
        else if (imc < 35 ) {
            message="Grade I Obesity";
        }
        else if (imc < 40 ) {
            message="Grade II Obesity";
        }
        else {
            message="Grade III Obesity";        
        }
        return message;
    }

    //provide Abdominal Circunderence health classification
    public String getAbdCircRisk() {
        String message;
        switch (gender) {
        case 1: //male        
            if (circunference < 90 ) {
                message="Normal risk";
            }
            else if (circunference < 94 ) {
                message="Average risk";
            }
            else if (circunference < 102 ) {
                message="High risk";
            }
            else {
                message="Very high risk";        
            }
            break;
        case 2: //female        
            if (circunference < 80 ) {
                message="Normal risk";
            }
            else if (circunference < 84 ) {
                message="Average risk";
            }
            else if (circunference < 88 ) {
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

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="Patient Id: "+patientNo;
        message=message+"\nPatient Name: "+name;
        message=message+"\nPatient Surname: "+surname;
        message=message+"\nPatient Gender: "+gender;
        message=message+"\nPatient Height: "+height;
        message=message+"\nPatient Weight: "+weight;
        message=message+"\nPatient Abdominal Circunference: "+circunference;
        
        return message;
    }
}