package sae;

/**
 * Représente une affectation entre un hôte et un visiteur.
 * Cette classe stocke les informations des deux étudiants ainsi que leur score d'affinité.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class Affectation {
    
    /** L'étudiant qui reçoit le visiteur. */
    private Student hote;

    /** L'étudiant visiteur. */
    private Student visiteur;

    /** La valeur d'affinité entre l'hôte et le visiteur. */
    private double affinite;

    /**
     * Constructeur de l'affectation.
     * Initialise l'hôte et le visiteur, puis calcule leur affinité.
     *
     * @param visiteur L'étudiant visiteur.
     * @param hote L'étudiant qui accueille le visiteur.
     */
    public Affectation(Student visiteur, Student hote) {
        this.hote = hote;
        this.visiteur = visiteur;
        this.affinite = visiteur.calculAffinite(hote);
    }

    /**
     * Renvoie l'étudiant hôte.
     *
     * @return L'étudiant qui reçoit le visiteur.
     */
    public Student getHote() {
        return hote;
    }

    /**
     * Renvoie l'étudiant visiteur.
     *
     * @return L'étudiant qui est affecté à un hôte.
     */
    public Student getVisiteur() {
        return visiteur;
    }

    /**
     * Renvoie la valeur d'affinité entre l'hôte et le visiteur.
     *
     * @return La valeur de l'affinité calculée.
     */
    public double getAffinite() {
        return affinite;
    }

    /**
     * Modifie la valeur d'affinité entre l'hôte et le visiteur.
     *
     * @param affinite La nouvelle valeur d'affinité à définir.
     */
    public void setAffinite(double affinite) {
        this.affinite = affinite;
    }

    /**
     * Retourne une représentation textuelle de l'affectation.
     * Affiche le visiteur, la valeur d'affinité et l'hôte.
     *
     * @return Une chaîne de caractères représentant l'affectation.
     */
    @Override
    public String toString() {
        return "[" + visiteur.getNom() + ", " + visiteur.getPrenom() + "] " + this.affinite + " [" + hote.getNom() + ", " + hote.getPrenom() + "]";
    }
}
