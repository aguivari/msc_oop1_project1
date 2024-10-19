import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private String surname;
    private int dob;
    private int mob;
    private int yob;

    //Constructors
    //Constructor with no parameter
    public Person() {
        name="";
        surname="";
        dob=0;
        mob=0;
        yob=0;
    }

    //Constructor with all parameters 
    public Person(  String personName, 
                    String personSurname, 
                    int personDoB, 
                    int personMoB, 
                    int personYoB) {
        name=personName;
        surname=personSurname;
        dob=personDoB;
        mob=personMoB;
        yob=personYoB;        
    }
    
    //Mutator methods
    //set person Name
    public void setName(String argument) {
        name = argument;
    }
    //set person Surname
    public void setSurname(String argument) {
        surname = argument;
    }
    //set person DoB
    public void setDoB(int argument) {
        dob = argument;
    }
    //set person MoB
    public void setMoB(int argument) {
        mob = argument;
    }
    //set person YoB
    public void setYoB(int argument) {
        yob = argument;
    }
 
    //Assessor methods
    //assess person Name
    public String getName(){
        return name;
    }
    //assess person Surname
    public String getSurname(){
        return name;
    }
    //assess person DoB
    public int getDoB(){
        return dob;
    }
    //assess person MoB
    public int getMoB(){
        return mob;
    }
    //assess person YoB
    public int getYoB(){
        return yob;
    }
    //assess person full DoB
    public String getFullDoB(){
        return dob+"/"+mob+"/"+yob;
    }
    //assess person age 
    public int getAge()   
    {  
        LocalDate today = LocalDate.now();  
        LocalDate birth = LocalDate.parse(yob+"-"+mob+"-"+dob);
        
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
        message=message+"\nperson Name: "+name;
        message=message+"\nperson Surname: "+surname;
        message=message+"\nperson DoB: "+dob+"/"+mob+"/"+yob;
        
        return message;
    }
}