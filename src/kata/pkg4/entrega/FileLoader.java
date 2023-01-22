/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata.pkg4.entrega;

/**
 *
 * @author aleja
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileLoader implements Loader{
    private final File file;

    public FileLoader(File file) {
        this.file = file;
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
            BufferedReader reader = createReader();
            String nextLine = nextLine();
            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public String next() {
                String line = nextLine;
                nextLine = nextLine();
                return line;
            }

            private BufferedReader createReader() {
                try {
                    return new BufferedReader(new FileReader(file));
                } catch (FileNotFoundException ex) {
                    return null;
                }
            }

            private String nextLine() {
                try {
                    return reader.readLine();
                } catch (IOException ex) {
                    return null;
                }
            }   
        };
    }
    
}
