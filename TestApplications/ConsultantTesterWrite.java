package TestApplications;
import java.util.ArrayList; 

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality;

public class ConsultantTesterWrite {
    static ArrayList<Consultant> consultantList = new ArrayList<Consultant>();
    public static void main(String[] args) {
        String consultantsFile = "files/consultants.bin";

        consultantList.add(new Consultant());
        consultantList.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Joanne", "Snow", 24,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultantList.add(new Consultant("Ivan", "Snow", 25,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultantList) {
            System.out.println(consultant);
            System.out.println();
        }

        System.out.println("Writing list of consultants to file "+consultantsFile);
        Utils.writeConsultantsToDisk(consultantsFile, consultantList);
    }
}