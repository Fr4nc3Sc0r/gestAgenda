import java.io.*;
import java.util.StringTokenizer;

public class Agenda {
    // attributi
    private Contatto[] contatti = new Contatto[100];
    private int dimensione;

    // metodo costruttore
    public Agenda() {
        dimensione = 0;
    }

    public void inserisciContatto(Contatto contatto) {
        contatti[dimensione] = contatto;
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
            System.out.println("CONTATTO N. " + (i + 1) + "\n" + contatti[i]);
        }
    }

    public void importaContatti(String percorso) throws IOException {
        FileReader f = new FileReader(percorso);
        BufferedReader fIN = new BufferedReader(f);

        System.out.println("comunicazione aperta");

        String s;

        try {
            do {
                s = fIN.readLine();

                StringTokenizer st = new StringTokenizer(s, ";");

                System.out.println("io sono partito");

                for (int i = 0; st.hasMoreTokens(); i++) {

                    Contatto temp = new Contatto(st.nextToken(), st.nextToken(), st.nextToken());

                    System.out.println(dimensione);

                    contatti[dimensione] = temp;

                    dimensione++;

                    System.out.println(contatti[i]);
                }

            } while (s != null);
        } catch (NullPointerException e) {

        }

        f.close();
        fIN.close();
    }
}
