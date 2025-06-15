package sae;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

        Student student1, student2, student3, student4, student5;

        @BeforeEach
        public void initialisation() {

                student1=new Student("Matthieu","A","2006-05-02","France","true","true","false","false","false","false","lalala","sport,poney");
                student2=new Student("Mathéo","Lelong","2007-01-01","France","true","false","false","false","false","false","histoire","sport");
                student3=new Student("Lucie","Martin","2005-08-15","France","false","true","yes","false","végétarien","aucune","danse","dance");
                student4=new Student("Carlos","Gomez","2006-03-23","Espagne","true","false","false","yes","aucune","halal","musique","leer");
                student5=new Student("Aya","Tanaka","2007-12-12","Japon","false","true","yes","yes","sans gluten","végétarien","dessin","leer");
        }

        @Test
        public void calculAffiniteTest() {

                // modifier les valeurs en fonction des varables

                assertEquals(3.5, student1.calculAffinite(student2));
                assertEquals(2.5, student1.calculAffinite(student3));
                assertEquals(2.5, student1.calculAffinite(student4));
                assertEquals(4.0, student3.calculAffinite(student2));
                assertEquals(1.0, student4.calculAffinite(student2));
                assertEquals(4.0, student5.calculAffinite(student2));
        }
}
