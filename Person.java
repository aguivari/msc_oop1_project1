import java.time.LocalDate;
import java.time.Period;

enum Gender {
    MALE,
    FEMALE,
    UNDEFINED
}

enum DateFormat {
    DMY,
    YMD,
    MDY
}

public class Person {
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

    //return person full DoB
    public String getFullDoB(DateFormat format){
        String sdob=String.format("%02d", this.dob);
        String smob=String.format("%02d", this.mob);
        String syob=String.format("%04d", this.yob);
        return switch (format) {
            case DateFormat.DMY   -> sdob+"-"+smob+"-"+syob;
            case DateFormat.YMD   -> syob+"-"+smob+"-"+sdob;
            case DateFormat.MDY   -> smob+"-"+sdob+"-"+syob;
            default -> "Undefined";
        };
    }
    //return person age in years
    public String getAge()   
    {  
        LocalDate today = LocalDate.now();  
        LocalDate birth = LocalDate.parse(this.getFullDoB(DateFormat.YMD));
        
        if ((birth != null) && (today != null)) {  
            Period age=Period.between(birth, today);
            String message="";
            if (age.getYears()>0) {
                message+=age.getYears()+" Years ";
            }
            if (age.getMonths()>0) {
                message+=age.getMonths()+" Months ";
            }
            if (age.getDays()>0) {
                message+=age.getDays()+" Days";
            }
            return message;

        } else {  
            return "Error getting age";  
        }  
    }

    //Overriding toString() method
    @Override
    public String toString() {
        String message;
        message="";
        message=message+"\nperson Name: "+this.name;
        message=message+"\nperson Surname: "+this.surname;
        message=message+"\nperson DoB: "+getFullDoB(DateFormat.DMY);
        message=message+"\nperson Age: "+this.getAge();
        message=message+ "\nperson Gender: "+ switch (this.gender) {
                case Gender.MALE   -> "Male";
                case Gender.FEMALE -> "Female";
                case Gender.UNDEFINED -> "Undefined";
            };
        return message;
    }
}