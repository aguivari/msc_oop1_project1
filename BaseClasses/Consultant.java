package BaseClasses;

import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality;

public final class Consultant extends Person  {
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
    public Consultant(String consultantName,
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
        StringBuilder sb = new StringBuilder();

        sb.append("Consultant Id: ").append(this.consultantNo);
        sb.append(super.toString());
        sb.append("\n").append("Consultant Speciality: ").append(this.speciality.label);
        sb.append("\n").append("Consultant Contract Type: ").append(this.contractType.label);
        return sb.toString();
    }
}