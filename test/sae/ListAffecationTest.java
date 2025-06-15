package sae;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListAffecationTest {

    Student student1, student2, student3, student4, student5;
    ListAffectation listTest;

    @BeforeEach
    public void initialisation() {
        student1 = new Student("Matthieu", "A", "2006-05-02", "France", "M", "M", "no", "no", "no", "no", "lalala",
                "sport,poney");
        student2 = new Student("Mathéo", "Lelong", "2007-01-01", "France", "M", "F", "no", "no", "no", "no", "histoire",
                "sport");
        student3 = new Student("Lucie", "Martin", "2005-08-15", "France", "F", "M", "yes", "no", "végétarien", "aucune",
                "danse", "dance");
        student4 = new Student("Carlos", "Gomez", "2006-03-23", "Espagne", "M", "F", "no", "yes", "aucune", "halal",
                "musique", "leer");
        student5 = new Student("Aya", "Tanaka", "2007-12-12", "Japon", "F", "M", "yes", "yes", "sans gluten",
                "végétarien", "dessin", "leer");

        listTest = new ListAffectation();
    }

    @Test
    public void addStudent() {
        listTest.addStudent(student1);
        assertEquals(listTest.getStudents().get(0), student1);

        // ajouter autres test pertinent si necessaire
    }

    @Test
    public void chargerCSVTest() {
        ListAffectation listTest = new ListAffectation();
        listTest.chargerCSV("infoetu.csv");
        for (Student etudiant : listTest.getStudents()) {
            System.out.println("" + etudiant.toString());
        }
        assertEquals("listTest", "listTest");
    }
}
