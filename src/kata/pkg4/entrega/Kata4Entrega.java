
package kata.pkg4.entrega;

/**
 *
 * @author aleja
 */
import java.io.File;
public class Kata4Entrega {
    public static void main(String[] args) {
        Iterable<String> items = new MailLoader(new FileLoader(new File("email.txt"))).items();
        for (String mail : items) System.out.println(mail);
    }
    
}
