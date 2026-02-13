import java.io.*;
import java.util.StringTokenizer;

public class Agenda {
    //attributi
    private Contatto[] contatti = new Contatto[100];
    private int dimensione;
    
    //metodo costruttore
    public Agenda() {
        dimensione = 0;
    }
    
    public void inserisciContatto(Contatto contatto) {
        contatti[dimensione] = contatto;
        dimensione++;
        try{
            FileWriter f = new FileWriter("agenda.txt", true);
            PrintWriter file = new PrintWriter(f);
            file.println(contatto.getCognome() + ";" + contatto.getNome() + ";" + contatto.getTelefono());
            f.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void stampaContatti() {
        for(int i = 0; i < dimensione; i++) {
            System.out.println("CONTATTO N. " + (i+1) + "\n" + contatti[i]);
        }
    }
}
