import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("000001", "Bilbo", "Baggins", "Esq.", 1060);
        p2 = new Person("000002", "Frodo", "Baggins", "Esq.", 1120);
    }

    @Test
    void setFirstName()
    {
        p1.setFirstName("Aaa");
        assertEquals("Bill", p1.getFirstName());                            //Failed
    }

    @Test
    void setLastName()
    {
        p2.setLastName("Baggins");
        assertEquals("Baggins", p2.getLastName());                          //Success
    }

    @Test
    void setTitle()
    {
        p1.setTitle("Esq.");
        assertEquals("Esq.", p1.getTitle());                                //Success
    }

    @Test
    void toCSVDataRecord()                                                          //Success
    {
        p1.toCSVDataRecord();
        assertEquals("000001, Bilbo, Baggins, Esq., 1060", p1.toCSVDataRecord());
    }

    @Test
    void testToString()                                                             //Success
    {
        p1.toString();
        assertEquals("Person{idString='000001', firstName='Bilbo', lastName='Baggins', title='Esq.', birthYear=1060}", p1.toString());
    }

    @Test
    void fullName() {
        p1.fullName();
        assertEquals("Bilbo Baggins", p1.fullName());                       //Success
    }

    @Test
    void formalName() {
        p1.formalName();
        assertEquals("Esq. Bilbo Baggins", p1.formalName());                //Success
    }

    @Test
    void getAge() {
        p1.getAge();
        assertEquals("963", p1.getAge());                                   //Success
    }

    @Test
    void getAgeCalc()
    {
        p1.getAgeCalc(2023);
        assertEquals("963", p1.getAgeCalc(2023));                      //Success
    }
}