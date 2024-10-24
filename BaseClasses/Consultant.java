package BaseClasses;

import  Enums.ContractType;
import  Enums.DateFormat;
import  Enums.Gender;
import  Enums.Speciality;

public class Consultant extends Person  {
    private static int baseConsultantNo=0;
    private int consultantNo;
    private Speciality speciality;
    private ContractType contractType;

    //Constructors
    //Constructor with no parameter, using this()
    public Consultant() {
        this("","",1,1,1,Gender.UNDEFINED, Speciality.UNDEFINED, ContractType.UNDEFINED);
    }

    //Constructor with some parameter, using this()
    public Consultant(String consultantName, 
                String consultantSurname, 
                int consultantDoB,
                int consultantMoB,
                int consultantYoB,
                Gender consultantGender) {
        this(consultantName,consultantSurname,consultantDoB,consultantMoB,consultantYoB,consultantGender, Speciality.UNDEFINED, ContractType.UNDEFINED);
    }

    //Constructor with all parameters , using super() to pass values to base Person class
    public Consultant( String consultantName, 
                    String consultantSurname, 
                    int consultantDoB,
                    int consultantMoB,
                    int consultantYoB,
                    Gender consultantGender, 
                    Speciality consultantSpeciality,
                    ContractType consultantContractType) {
        super(consultantName,consultantSurname,consultantDoB,consultantMoB,consultantYoB,consultantGender);
        incrementBaseConsultantNo();
        this.consultantNo=baseConsultantNo;
        this.speciality=consultantSpeciality;
        this.contractType=consultantContractType;       
    }
    
    private void incrementBaseConsultantNo() {
        baseConsultantNo++;
    }

    //Mutator methods
    //set consultant Speciality
    public void setSpeciality(Speciality argument) {
        this.speciality = argument;
    }
    //set consultant Contract Type
    public void setContractType(ContractType argument) {
        this.contractType = argument;
    }
    

    //Assessor methods
    //assess consultant Id
    public int getConsultantNo(){
        return this.consultantNo;
    }
    //assess consultant Speciality
    public Speciality getSpeciality(){
        return this.speciality;
    }
    //assess consultant contract type
    public ContractType getContractType(){
        return this.contractType;
    }

    //allows for setting the baseConsultantNo in case reading from file.
    public void resetBaseConsultantNo(int argument) {
        baseConsultantNo=argument;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="Consultant Id: "+consultantNo;
        message=message + super.toString();
        message=message + "\nConsultant Speciality: " + switch (this.speciality) {
            case Speciality.NUTRITION   -> Speciality.NUTRITION.label;
            case Speciality.ENDOCHRINOLOGY -> Speciality.ENDOCHRINOLOGY.label;
            case Speciality.PHYSIOTHERAPY   -> Speciality.PHYSIOTHERAPY.label;
            case Speciality.GENERALPRACTICE -> Speciality.GENERALPRACTICE.label;
            case Speciality.UNDEFINED -> Speciality.UNDEFINED.label;
        }; 
        message=message + "\nConsultant Contract Type: " + switch (this.contractType) {
            case ContractType.PERMANENT -> ContractType.PERMANENT.label;
            case ContractType.TEMPORARY -> ContractType.TEMPORARY.label;
            case ContractType.UNDEFINED -> ContractType.UNDEFINED.label;
        }; 

        return message;
    }
}