import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Agenda {
    // attributi
    private Vector<Contatto> contatti = new Vector<Contatto>();
    private int dimensione;

    // metodo costruttore
    public Agenda() {
        dimensione = 0;
    }

    public void inserisciContatto(Contatto contatto) {
        contatti.add(contatto);
        dimensione++;
        try {
            FileWriter f = new FileWriter("agenda.txt", true);
            PrintWriter file = new PrintWriter(f);
            file.println(contatto.getCognome() + ";" + contatto.getNome() + ";" + contatto.getTelefono() + ";");
            f.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void stampaContatti() {
        for (int i = 0; i < dimensione; i++) {
            System.out.println("CONTATTO N. " + (i + 1) + "\n" + contatti.elementAt(i));
        }
    }

    public void importaContatti(String percorso) throws IOException {
        FileReader f = new FileReader(percorso);
        BufferedReader fIN = new BufferedReader(f);

        String s;

        try {
            do {
                s = fIN.readLine();

                StringTokenizer st = new StringTokenizer(s, ";");

                for (int i = 0; st.hasMoreTokens(); i++) {

                    Contatto temp = new Contatto(st.nextToken(), st.nextToken(), st.nextToken());

                    contatti.add(temp);

                }

            } while (s != null);
        } catch (NullPointerException e) {

        }

        f.close();
        fIN.close();
    }
}
