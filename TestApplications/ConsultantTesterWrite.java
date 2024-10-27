package TestApplications;
import java.util.ArrayList;

import  AuxClasses.Utils;
import  BaseClasses.Consultant;
import  Enums.ContractType;
import  Enums.Gender;
import  Enums.Speciality;
import Interfaces.ConsultantAPI;


public class ConsultantTesterWrite {
   
    public static void main(String[] args) {
        String consultantsFile = "files/consultants.bin";

        ConsultantAPI consultants=new ConsultantAPI();
       

        consultants.add(new Consultant());
        consultants.add(new Consultant("John", "Snow", 23,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultants.add(new Consultant("Joanne", "Snow", 24,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultants.add(new Consultant("Ivan", "Snow", 25,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultants.getAll()) {
            System.out.println(consultant);
            System.out.println();
        }

        System.out.println("Writing list of consultants to file "+consultantsFile);
        consultants.writeToDisk(consultantsFile);
    }
}