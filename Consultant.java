enum Speciality {
    NUTRITION,
    ENDOCHRINOLOGY,
    PHYSIOTHERAPY,
    GENERALPRACTICE,
    UNDEFINED
}

enum ContractType {
    PERMANENT,
    TEMPORARY,
    UNDEFINED
}
public class Consultant extends Person {
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
    public int getconsultantNo(){
        return this.consultantNo;
    }
    //assess consultant Speciality
    public Speciality getSpeciality(){
        return this.speciality;
    }
    //assess consultant Weight
    public ContractType getContractType(){
        return this.contractType;
    }

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="consultant Id: "+consultantNo;
        message=message+super.toString();
        message=message+ "\nconsultant Speciality: "+ switch (this.speciality) {
            case Speciality.NUTRITION   -> "Nutrition";
            case Speciality.ENDOCHRINOLOGY -> "Endochrinology";
            case Speciality.PHYSIOTHERAPY   -> "Physiotherapy";
            case Speciality.GENERALPRACTICE -> "General Practice";
            case Speciality.UNDEFINED -> "Undefined";
        }; 
        message=message+"\nconsultant Contract Type: "+switch (this.contractType) {
            case ContractType.PERMANENT   -> "Permanent";
            case ContractType.TEMPORARY -> "Temporary";
            case ContractType.UNDEFINED -> "Undefined";
        }; 

        return message;
    }
}