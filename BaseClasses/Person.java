package BaseClasses;
import java.io.Serializable;

import Enums.DateFormat;
import Enums.Gender;
import AuxClasses.Utils;

public class Person implements Serializable {
    private String name;
    private String surname;
    private int dob;
    private int mob;
    private int yob;
    private Gender gender;

    //Constructors
    //Constructor with no parameter, using this()
    public Person() {
        this("","",1,1,1,Gender.UNDEFINED);
    }

    //Constructor with all parameters 
    public Person(  String personName, 
                    String personSurname, 
                    int personDoB, 
                    int personMoB, 
                    int personYoB,
                    Gender personGender) {
        this.name=personName;
        this.surname=personSurname;
        this.dob=personDoB;
        this.mob=personMoB;
        this.yob=personYoB;   
        this.gender=personGender;     
    }
    
    //Mutator methods
    //set person Name
    public void setName(String argument) {
        this.name = argument;
    }
    //set person Surname
    public void setSurname(String argument) {
        this.surname = argument;
    }
    //set person DoB
    public void setDoB(int argument) {
        this.dob = argument;
    }
    //set person MoB
    public void setMoB(int argument) {
        this.mob = argument;
    }
    //set person YoB
    public void setYoB(int argument) {
        this.yob = argument;
    }
    //set person Gender
    public void setGender(Gender argument) {
        this.gender = argument;
    }
 
    //Assessor methods
    //assess person Name
    public String getName(){
        return this.name;
    }
    //assess person Surname
    public String getSurname(){
        return this.surname;
    }
    //assess person DoB
    public int getDoB(){
        return this.dob;
    }
    //assess person MoB
    public int getMoB(){
        return this.mob;
    }
    //assess person YoB
    public int getYoB(){
        return this.yob;
    }
    //assess person gender
    public Gender getGender(){
        return this.gender;
    }
    
    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        String childType;

        childType="Person";
        if ( this instanceof Patient) {
            childType="Patient";
        } else if ( this instanceof Consultant) {
            childType="Consultant";
        }        

        message="";
        message=message + "\n"+childType+" Name: " + this.name;
        message=message + "\n"+childType+" Surname: " + this.surname;
        message=message + "\n"+childType+" DoB: " + Utils.getFullDoB(this, DateFormat.DMY);
        message=message + "\n"+childType+" Age: " + Utils.getAge(this);
        message=message + "\n"+childType+" Gender: " + switch (this.gender) {
                case Gender.MALE   -> Gender.MALE.label;
                case Gender.FEMALE -> Gender.FEMALE.label;
                case Gender.UNDEFINED -> Gender.UNDEFINED.label;
            };
        return message;
    }
}