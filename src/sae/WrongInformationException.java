package sae;
/**
 * Class permettant de creer une exception
 * 
 * @author <a href="mailto:aubin2109@gmail.com">Aubin B</a>
 * @author <a href="mailto:matheo778@gmail.com">Mathéo D</a>
 * @author <a href="mailto:calmatthieu@yahoo.com">Mathieu C</a>
 * @author <a href="mailto:aymericjacquey@gmail.com">Aymeric C</a>
 * @version 21.0.7
 */
public class WrongInformationException extends Exception{
    public WrongInformationException(String s){
        super("WrongInformationException : " + s);
    }
}
