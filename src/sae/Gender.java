package sae;
/**
 * Représente les differents type de genres possible
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public enum Gender {
    /**
     * enum enrichie des different type de genre 
     */
    FEMALE("female"),MALE("male"),OTHER("other");

    private String genre;
    /**
     * permet de creer un genre
     * @param genre
     */
    private Gender(String genre){
        this.genre = genre;
    }
    /**
     * permet d'afficher le genre
     * @return le genre de la personne
     */
    public String getGenre(){
        return this.genre;
    }
}
