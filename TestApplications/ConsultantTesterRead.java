package TestApplications;
import java.util.ArrayList;

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality; 

public class ConsultantTesterRead {
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {        
        String consultantsFile = "files/consultants.bin";
        int max;
   
        System.out.println("Reading list of consultants from file"+ consultantsFile);
        consultantList=Utils.readConsultantsFromDisk(consultantsFile);

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }

        max=Utils.getMaxConsultantNo(consultantList);
        System.out.println("Resetting baseConsultantNo to "+max);
        consultantList.get(0).resetBaseConsultantNo(max);

        consultantList.add(new Consultant());
        consultantList.add(new Consultant("John", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Joanne", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Ivan", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }
    }
}