import java.time.LocalDate;
import java.time.Period;

enum Gender {
    MALE,
    FEMALE,
    UNDEFINED
}

public class Person {
    private String name;
    private String surname;
    private int dob;
    private int mob;
    private int yob;
    private Gender gender; // 1 = biological male, 2=biological female, 0=not defined


    //Constructors
    //Constructor with no parameter
    public Person() {
        this.name="";
        this.surname="";
        this.dob=0;
        this.mob=0;
        this.yob=0;
        this.gender=Gender.UNDEFINED;
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

    //return person full DoB
    public String getFullDoB(){
        return this.dob+"/"+this.mob+"/"+this.yob;
    }
    //return person age in years
    public int getAge()   
    {  
        LocalDate today = LocalDate.now();  
        LocalDate birth = LocalDate.parse(this.yob+"-"+this.mob+"-"+this.dob);
        
        if ((birth != null) && (today != null)) {  
            return Period.between(birth, today).getYears();  
        } else {  
            return -1;  
        }  
    }

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="";
        message=message+"\nperson Name: "+this.name;
        message=message+"\nperson Surname: "+this.surname;
        message=message+"\nperson DoB: "+this.dob+"/"+this.mob+"/"+this.yob;
        
        message=message+ "\nperson Gender: "+ switch (this.gender) {
                case Gender.MALE   -> "Male";
                case Gender.FEMALE -> "Female";
                default -> "Undefined";
            }
        ;

        
        return message;
    }
}