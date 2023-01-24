import static java.lang.System.in;
import java.util.Scanner;

public class Person
{
    private String idString;
    private String firstName;
    private String lastName;
    private String title;
    private int birthYear;

    public Person(String idString, String firstName, String lastName, String title, int birthYear)
    {
        this.idString = idString;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.birthYear = birthYear;
    }

    public String getIdString() {return idString;}                                  //Get ID

    public String getFirstName() {return firstName;}                                //Get first name
    public void setFirstName(String firstName) {this.firstName = firstName;}        //Set first name

    public String getLastName() {return lastName;}                                  //Get last name
    public void setLastName(String lastName) {this.lastName = lastName;}            //Set last name

    public String getTitle() {return title;}                                        //Get title
    public void setTitle(String title) {this.title = title;}                        //Set title

    public int getBirthYear() {return birthYear;}                                   //Get birth year

    public String toCSVDataRecord()
    {
        return (idString + ", " + firstName + ", " + lastName + ", " + title + ", " + birthYear);
    }

    public String fullName() {return (firstName + " " + lastName);}

    public String formalName() {return title + " " + fullName();}

    public String getAge()
    {
        int ageCurrent = 2023 - birthYear;
        String currentAge = String.valueOf(ageCurrent);
        return (currentAge);
    }

    public String getAgeCalc(int year)
    {
        int ageCalculated = year - birthYear;
        String calculatedAge = String.valueOf(ageCalculated);
        return calculatedAge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idString='" + idString + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}