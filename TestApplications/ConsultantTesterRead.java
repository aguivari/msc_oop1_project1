package TestApplications;
import java.util.ArrayList;

import AuxClasses.Utils;
import BaseClasses.Consultant;
import Enums.ContractType;
import Enums.Gender;
import Enums.Speciality;
import Interfaces.ConsultantAPI;

public class ConsultantTesterRead {
    public static void main(String[] args) {
        String consultantsFile = "files/consultants.bin";
        int max;
        ConsultantAPI consultants=new ConsultantAPI();
  
        System.out.println("Reading list of consultants from file"+ consultantsFile);
        consultants.readFromDisk(consultantsFile);

        for (Consultant consultant: consultants.getAll()) {
            System.out.println(consultant);
            System.out.println();
        }

        consultants.add(new Consultant());
        consultants.add(new Consultant("John", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultants.add(new Consultant("Joanne", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));
        consultants.add(new Consultant("Ivan", "Snow", 18,10,1985, Gender.MALE, Speciality.ENDOCHRINOLOGY, ContractType.PERMANENT));

        for (Consultant consultant: consultants.getAll()) {
            System.out.println(consultant);
            System.out.println();
        }
    }
}