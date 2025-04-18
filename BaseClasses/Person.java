package BaseClasses;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import Enums.DateFormat;
import Enums.Gender;
import AuxClasses.Date;

public sealed class Person implements Serializable permits Patient, Consultant {
    private String name;
    private String surname;
    private Date dob;
    private Gender gender;

    // Constructors
    // Constructor with no parameter, using this(), uses current date
    public Person() {
        this("",
                "",
                1,
                1,
                1,
                Gender.UNDEFINED);
    }

    // Constructor with all parameters
    public Person(String personName,
            String personSurname,
            Date birthDate,
            Gender personGender) {
        this.name = personName;
        this.surname = personSurname;
        this.dob = birthDate;
        this.gender = personGender;
    }

    // Constructor with all parameters, discrete DoB parameters
    public Person(String personName,
            String personSurname,
            int personDoB,
            int personMoB,
            int personYoB,
            Gender personGender) {
        this.name = personName;
        this.surname = personSurname;
        this.dob = new Date(personDoB, personMoB, personYoB);
        this.gender = personGender;
    }

    // copy constructor
    public Person(Person p) {
        this(p.getName(),
                p.getSurname(),
                new Date(p.getDoB()),
                p.getGender());
    }

    // Mutator methods
    // set person Name
    public void setName(String argument) {
        this.name = argument;
    }

    // set person Surname
    public void setSurname(String argument) {
        this.surname = argument;
    }

    // set person Date of birth (date)
    public void setDoB(Date argument) {
        this.dob = argument;
    }

    // set person Date of birth (day, month, year)
    public void setDoB(int day, int month, int year) {
        this.dob.setDay(day);
        this.dob.setMonth(month);
        this.dob.setYear(year);
    }

    // set person DoB
    public void setBirthDay(int argument) {
        this.dob.setDay(argument);
    }

    // set person MoB
    public void setBirthMonth(int argument) {
        this.dob.setMonth(argument);
    }

    // set person YoB
    public void setBirthYear(int argument) {
        this.dob.setYear(argument);
    }

    // set person Gender
    public void setGender(Gender argument) {
        this.gender = argument;
    }

    // Assessor methods
    // assess person Name
    public String getName() {
        return this.name;
    }

    // assess person Surname
    public String getSurname() {
        return this.surname;
    }

    // assess person full nname
    public String getFullName() {
        return this.name + " " + this.surname;
    }

    // assess person DoB
    public int getBirthDay() {
        // return this.dob;
        return this.dob.getDay();
    }

    // assess person MoB
    public int getBirthMonth() {
        // return this.mob;
        return this.dob.getMonth();
    }

    // assess person YoB
    public int getBirthYear() {
        // return this.yob;
        return this.dob.getYear();
    }

    // assess person YoB
    public Date getDoB() {
        // return this.yob;
        return this.dob;
    }

    // assess DOB in default format (DMY)
    public String getFullDate() {
        return this.getFullDate(DateFormat.DMY);
    }

    // assess DOB in specified format
    public String getFullDate(DateFormat format) {
        return this.dob.getFullDate(format);
    }

    // assess person age in days, months years
    public String getAge() {
        return this.dob.getDateAge();
    }

    // assess person gender
    public Gender getGender() {
        return this.gender;
    }

    // Overriding toString() method
    @Override
    public String toString() {
        String childType;
        StringBuilder sb = new StringBuilder();

        ResourceBundle personResourceBundle = ResourceBundle.getBundle("HealthCollector", Locale.getDefault());

        childType = personResourceBundle.getString("Person");
        if (this instanceof Patient) {
            childType = personResourceBundle.getString("Patient");
        } else if (this instanceof Consultant) {
            childType = personResourceBundle.getString("Consultant");
        }

        sb.append("\n").append(childType).append(" ");
        sb.append(personResourceBundle.getString("Name")).append(": ").append(this.name);
        sb.append("\n").append(childType).append(" ");
        sb.append(personResourceBundle.getString("Surname")).append(": ").append(this.surname);
        sb.append("\n").append(childType).append(" ");
        sb.append(personResourceBundle.getString("DoB")).append(": ").append(this.getFullDate());
        sb.append("\n").append(childType).append(" ");
        sb.append(personResourceBundle.getString("Age")).append(": ").append(this.getAge());
        sb.append("\n").append(childType).append(" ");
        sb.append(personResourceBundle.getString("Gender")).append(": ");
        sb.append(personResourceBundle.getString(this.gender.label));
        return sb.toString();
    }
}