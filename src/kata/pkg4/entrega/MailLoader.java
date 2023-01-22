/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata.pkg4.entrega;

/**
 *
 * @author aleja
 */

import java.util.Iterator;
import java.util.regex.Pattern;

public class MailLoader implements Loader {
    private final Loader loader;
    private static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    

    public MailLoader( Loader loader) {
        this.loader = loader;
    }
    
    
    @Override
    public Iterable<String> items() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return createIterator();
            }
        };
    }

    
    private Iterator<String> createIterator() {
        return new Iterator<String>() {
            Iterator<String> iterator = loader.items().iterator();
            String nextEmail = nextEmail();
            

            @Override
            public boolean hasNext() {
                return nextEmail != null;
            }

            @Override
            public String next() {
                String email = nextEmail;
                nextEmail = nextEmail();
                return email;
            }

            private String nextEmail() {
                while (true) {
                    String line = iterator.next();
                    if (line == null) return null;
                    if (isEmail(line)) return line;
                }
            }

            private boolean isEmail(String line) {
                return pattern.matcher(line).matches();
            }           
        };
    }
}

