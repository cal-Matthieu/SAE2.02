package sae;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant un étudiant avec ses informations personnelles et ses préférences.
 * Permet de stocker et manipuler les données d'un étudiant pour un système de jumelage.
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */

public class Student {
    /**
     * Map contenant les informations de l'étudiant.
     * Les clés correspondent aux critères définis dans la map statique 'critere'.
     */
    private Map<String, String> information;

    /**
     * Map statique définissant les critères d'un étudiant et leur type.
     * T = Texte, D = Date (format "AAAA-MM-JJ"), B = Booléen ("true"/"false")
     */
    public static Map<String, String> critere = new HashMap<String, String>();

    // Initialisation des critères et de leurs types
    static {
        critere.put("prenom", "T");
        critere.put("nom", "T");
        critere.put("dateNaissance", "D");      // format "AAAA-MM-JJ"
        critere.put("pays", "T");
        critere.put("gender", "B");             // true = garçon 
        critere.put("pairGender", "B");         // true = garçon
        critere.put("guestAnimalAllergy", "B");
        critere.put("hostHasAnimal", "B");
        critere.put("guestFood", "T");
        critere.put("hostFood", "T");
        critere.put("history", "T");
        critere.put("hobbies", "T");
    }

    /**
     * Constructeur par défaut initialisant la map d'informations.
     */
    public Student() {
        information = new HashMap<>();
    }

    /**
     * Constructeur complet initialisant toutes les informations de l'étudiant.
     * Effectue des validations sur les types de données.
     * 
     * @param prenom Prénom de l'étudiant
     * @param nom Nom de l'étudiant
     * @param dateNaissance Date de naissance au format "AAAA-MM-JJ"
     * @param pays Pays d'origine
     * @param gender Genre
     * @param pairGender Genre souhaité pour le partenaire
     * @param guestAnimalAllergy Allergie aux animaux de l'invité
     * @param hostHasAnimal Présence d'animaux chez l'hôte
     * @param guestFood Préférences alimentaires de l'invité (séparées par des virgules)
     * @param hostFood Préférences alimentaires de l'hôte (séparées par des virgules)
     * @param history Historique de l'étudiant
     * @param hobbies Centres d'intérêt (séparés par des virgules)
     */
    public Student(String prenom, String nom, String dateNaissance, String pays, String gender, String pairGender,
            String guestAnimalAllergy, String hostHasAnimal, String guestFood, String hostFood, String history,
            String hobbies) {
        this();
        try{
            if(!(prenom instanceof String)){
                throw new WrongInformationException("prenom invalide");
            }
            else {information.put("prenom", prenom);}
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        information.put("nom", nom);
        try{
            @SuppressWarnings("unused")
            LocalDate ld=LocalDate.parse(dateNaissance);
            information.put("dateNaissance", dateNaissance);

        }catch(DateTimeParseException e){
            System.out.println("WrongInformationException : date invalide");
        }
        try{
            if(!(pays instanceof String)){
                throw new WrongInformationException("pays invalide");
            }
            information.put("pays", pays);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(gender instanceof String)){
                throw new WrongInformationException("genre invalide");
            }
            information.put("gender", gender);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(pairGender)) && (!"false".equals(pairGender))){
                throw new WrongInformationException("pairGender invalide");
            }
            information.put("pairGender", pairGender);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(guestAnimalAllergy)) && (!"false".equals(guestAnimalAllergy))){
                throw new WrongInformationException("guestAnimalAllergy invalide");
            }
            information.put("guestAnimalAllergy", guestAnimalAllergy);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if((!"true".equals(hostHasAnimal)) && (!"false".equals(hostHasAnimal))){
                throw new WrongInformationException("hostHasAnimal invalide");
            }
            information.put("hostHasAnimal", hostHasAnimal);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(gender instanceof String)){
                throw new WrongInformationException("guestFood invalide");
            }
            information.put("guestFood", guestFood);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(hostFood instanceof String)){
                throw new WrongInformationException("hostFood invalide");
            }
            information.put("hostFood", hostFood);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(history instanceof String)){
                throw new WrongInformationException("history invalide");
            }
            information.put("history", history);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
        try{
            if(!(hobbies instanceof String)){
                throw new WrongInformationException("hobbies invalide");
            }
            information.put("hobbies", hobbies);
        }catch(WrongInformationException e){
            System.out.println(e);
        }
    }

    /**
     * Définit le prénom de l'étudiant.
     * @param prenom Le prénom à enregistrer
     */
    public void setPrenom(String prenom) {
        information.put("prenom", prenom);
    }

    /**
     * Définit le nom de l'étudiant.
     * @param nom Le nom à enregistrer
     */
    public void setNom(String nom) {
        information.put("nom", nom);
    }

    /**
     * Définit la date de naissance de l'étudiant.
     * @param dateNaissance La date au format "AAAA-MM-JJ"
     */
    public void setDateNaissance(String dateNaissance) {
        information.put("dateNaissance", dateNaissance);
    }

    /**
     * Définit le pays d'origine de l'étudiant.
     * @param pays Le pays à enregistrer
     */
    public void setPays(String pays) {
        information.put("pays", pays);
    }

    /**
     * Définit le genre de l'étudiant.
     * @param gender Le genre ("true" pour masculin, "false" pour féminin)
     */
    public void setGender(String gender) {
        information.put("gender", gender);
    }

    /**
     * Définit le genre souhaité pour le partenaire.
     * @param pairGender Le genre ("true" pour masculin, "false" pour féminin)
     */
    public void setPairGender(String pairGender) {
        information.put("pairGender", pairGender);
    }

    /**
     * Définit si l'invité est allergique aux animaux.
     * @param guestAnimalAllergy "true" si allergique, "false" sinon
     */
    public void setGuestAnimalAllergy(String guestAnimalAllergy) {
        information.put("guestAnimalAllergy", guestAnimalAllergy);
    }

    /**
     * Définit si l'hôte possède des animaux.
     * @param hostHasAnimal "true" si l'hôte a des animaux, "false" sinon
     */
    public void setHostHasAnimal(String hostHasAnimal) {
        information.put("hostHasAnimal", hostHasAnimal);
    }

    /**
     * Définit les préférences alimentaires de l'invité.
     * @param guestFood Les préférences séparées par des virgules
     */
    public void setGuestFood(String guestFood) {
        information.put("guestFood", guestFood);
    }

    /**
     * Définit les préférences alimentaires de l'hôte.
     * @param hostFood Les préférences séparées par des virgules
     */
    public void setHostFood(String hostFood) {
        information.put("hostFood", hostFood);
    }

    /**
     * Définit l'historique de l'étudiant.
     * @param history L'historique à enregistrer
     */
    public void setHistory(String history) {
        information.put("history", history);
    }

    /**
     * Définit les hobbies de l'étudiant.
     * @param hobbies Les centres d'intérêt séparés par des virgules
     */
    public void setHobbies(String hobbies){
        information.put("hobbies", hobbies);
    }

    /**
     * Retourne le prénom de l'étudiant.
     * @return Le prénom de l'étudiant
     */
    public String getPrenom() {
        return information.get("prenom");
    }

    /**
     * Retourne le nom de l'étudiant.
     * @return Le nom de l'étudiant
     */
    public String getNom() {
        return information.get("nom");
    }

    /**
     * Retourne la date de naissance sous forme d'objet LocalDate.
     * @return La date de naissance
     */
    public LocalDate getDateNaissance() {
        return LocalDate.parse(information.get("dateNaissance"));
    }

    /**
     * Formate une date LocalDate en chaîne de caractères.
     * @param dateNaissance La date à formater
     * @return La date formatée en "yyyy-MM-dd"
     */
    public String getDateNaissance(LocalDate dateNaissance){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateNaissance.format(formatter);
    }

    /**
     * Retourne le pays d'origine de l'étudiant.
     * @return Le pays de l'étudiant
     */
    public String getPays() {
        return information.get("pays");
    }

    /**
     * Retourne le genre de l'étudiant.
     * @return "true" pour masculin, "false" pour féminin
     */
    public String getGender() {
        return information.get("gender");
    }

    /**
     * Retourne le genre souhaité pour le partenaire.
     * @return "true" pour masculin, "false" pour féminin
     */
    public String getPairGender() {
        return information.get("pairGender");
    }

    /**
     * Indique si l'invité est allergique aux animaux.
     * @return true si allergique, false sinon
     */
    public boolean getGuestAnimalAllergy() {
        return information.get("guestAnimalAllergy").equals("true");
    }

    /**
     * Indique si l'hôte possède des animaux.
     * @return true si l'hôte a des animaux, false sinon
     */
    public boolean getHostHasAnimal() {
        return information.get("hostHasAnimal").equals("true");
    }

    /**
     * Retourne les préférences alimentaires de l'invité sous forme de liste.
     * @return ArrayList des préférences alimentaires
     */
    public ArrayList<String> getGuestFood(){
        ArrayList<String> gestFood = new ArrayList<String>();
        String[] food = information.get("guestFood").split(",");

        for (String valeur : food){
            gestFood.add(valeur);
        }
        return gestFood;
    }

    /**
     * Retourne les préférences alimentaires de l'hôte sous forme de liste.
     * @return ArrayList des préférences alimentaires
     */
    public ArrayList<String> getHostFood(){
        ArrayList<String> hostFood = new ArrayList<String>();
        String[] food = information.get("hostFood").split(",");

        for (String valeur : food){
            hostFood.add(valeur);
        }
        return hostFood;
    }

    /**
     * Retourne l'historique de l'étudiant.
     * @return L'historique de l'étudiant
     */
    public String getHistory() {
        return information.get("history");
    }

    /**
     * Retourne la liste des hobbies de l'étudiant.
     * @return ArrayList des centres d'intérêt
     */
    public ArrayList<String> getHobbies() {
        ArrayList<String> hobbies = new ArrayList<>();
        String[] hobbie = information.get("hobbies").split(",");

        for (String valeur : hobbie){
            hobbies.add(valeur);
        }
        return hobbies;
    }

    /**
     * Détermine si l'étudiant est un hôte (vient d'Italie).
     * @return true si l'étudiant est un hôte, false sinon
     */
    public boolean isHote(){
        return this.getPays().equals("Italie");
    }

    /**
     * Calcule l'affinité entre cet étudiant et un autre étudiant.
     * L'affinité est basée sur:
     * - Compatibilité des genres (1.5 points par correspondance)
     * - Hobbies communs (1 point pour 1 hobby, 2 points pour 2+ hobbies)
     * - Proximité des dates de naissance (1 point si <1.5 ans d'écart)
     * 
     * @param student L'autre étudiant avec lequel calculer l'affinité
     * @return Le score d'affinité total
     */
    public double calculAffinite(Student student) {
        double affinite = 0;

        if (this.getPairGender() == student.getGender()) {
            affinite = affinite + 1.5;
        }
        if (this.getGender() == student.getPairGender()) {
            affinite = affinite + 1.5;
        }

        int nbCommonHobbies = 0;
        for (int i = 0; i < this.getHobbies().size(); i = i + 1) {
            for (int j = 0; j < student.getHobbies().size(); j = j + 1) {
                if (this.getHobbies().get(i).equals(student.getHobbies().get(j))) {
                    nbCommonHobbies = nbCommonHobbies + 1;
                }
            }
        }
        if (nbCommonHobbies == 1) {
            affinite = affinite + 1;
        }
        if (nbCommonHobbies >= 2) {
            affinite = affinite + 2;
        }

        int jourlimit = (int) (365 * 1.5);
        int thisDate = this.getDateNaissance().getYear() * 365 + this.getDateNaissance().getDayOfYear();
        int stdDate = student.getDateNaissance().getYear() * 365 + student.getDateNaissance().getDayOfYear();

        if (Math.abs(thisDate - stdDate) < jourlimit) {
            affinite++;
        }

        return affinite;
    }
    
    /**
     * Retourne une représentation textuelle de l'étudiant.
     * @return Le nom et prénom de l'étudiant séparés par un espace
     */
    @Override
    public String toString(){
        return ""+getNom()+" "+getPrenom();
    }
}