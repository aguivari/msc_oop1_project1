package BaseClasses;

import java.util.ResourceBundle;
import java.util.Locale;

import Enums.ContractType;
import Enums.Gender;
import Enums.Specialty;
import AuxClasses.Date;

public final class Consultant extends Person {
    private static int baseConsultantNo = 0;
    private int consultantNo;
    private Specialty specialty;
    private ContractType contractType;

    // Constructors
    // Constructor with no parameter, using this()
    public Consultant() {
        this("",
                "",
                1,
                1,
                1,
                Gender.UNDEFINED,
                Specialty.UNDEFINED,
                ContractType.UNDEFINED);
    }

    // Constructor with some parameter, using this()
    public Consultant(String consultantName,
            String consultantSurname,
            int consultantDoB,
            int consultantMoB,
            int consultantYoB,
            Gender consultantGender) {
        this(consultantName,
                consultantSurname,
                consultantDoB,
                consultantMoB,
                consultantYoB,
                consultantGender,
                Specialty.UNDEFINED,
                ContractType.UNDEFINED);
    }

    // Constructor with all parameters , using super() to pass values to base Person
    // class
    public Consultant(String consultantName,
            String consultantSurname,
            int consultantDoB,
            int consultantMoB,
            int consultantYoB,
            Gender consultantGender,
            Specialty consultantSpecialty,
            ContractType consultantContractType) {
        super(consultantName,
                consultantSurname,
                consultantDoB,
                consultantMoB,
                consultantYoB,
                consultantGender);
        incrementBaseConsultantNo();
        this.consultantNo = baseConsultantNo;
        this.specialty = consultantSpecialty;
        this.contractType = consultantContractType;
    }

    // Constructor with all parameter, DoB as Date class,
    // using super() to pass values to base Person class
    public Consultant(String consultantName,
            String consultantSurname,
            Date consultantDateOfBirth,
            Gender consultantGender,
            Specialty consultantSpecialty,
            ContractType consultantContractType) {
        super(consultantName,
                consultantSurname,
                consultantDateOfBirth,
                consultantGender);
        incrementBaseConsultantNo();
        this.consultantNo = baseConsultantNo;
        this.specialty = consultantSpecialty;
        this.contractType = consultantContractType;
    }

    // copy constructor
    public Consultant(Consultant c) {
        this(c.getName(),
                c.getSurname(),
                new Date(c.getDoB()),
                c.getGender(),
                c.getSpecialty(),
                c.getContractType());
    }

    private void incrementBaseConsultantNo() {
        baseConsultantNo++;
    }

    // Mutator methods
    // set consultant Specialty
    public void setSpecialty(Specialty argument) {
        this.specialty = argument;
    }

    // set consultant Contract Type
    public void setContractType(ContractType argument) {
        this.contractType = argument;
    }

    // Assessor methods
    // assess consultant Id
    public int getConsultantNo() {
        return this.consultantNo;
    }

    // assess consultant Specialty
    public Specialty getSpecialty() {
        return this.specialty;
    }

    // assess consultant contract type
    public ContractType getContractType() {
        return this.contractType;
    }

    // allows for setting the baseConsultantNo in case reading from file.
    public void resetBaseConsultantNo(int argument) {
        baseConsultantNo = argument;
    }

    // Overriding toString() method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ResourceBundle consultantResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());

        sb.append(consultantResourceBundle.getString("ConsultantId"));
        sb.append(": ").append(this.consultantNo);
        sb.append(super.toString());
        sb.append("\n").append(consultantResourceBundle.getString("ConsultantSpecialty"));
        sb.append(": ").append(consultantResourceBundle.getString(this.specialty.label));
        sb.append("\n").append(consultantResourceBundle.getString("ConsultantContractType"));
        sb.append(": ").append(consultantResourceBundle.getString(this.contractType.label));
        return sb.toString();
    }

}