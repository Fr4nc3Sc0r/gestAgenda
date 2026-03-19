
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int scelta;
        String cognome, nome, telefono;
        do {
            System.out.println("1 - Inserisci contatto in agenda");
            System.out.println("2 - Stampa tutti i contatti");
            System.out.println("3 - Importa contatti");
            System.out.println("4 - Esci");
            scelta = input.nextInt();
            switch (scelta) {
                case 1: {
                    System.out.println("Inserisci cognome, nome e numero di telefono: ");
                    cognome = input.next();
                    nome = input.next();
                    telefono = input.next();
                    Contatto c = new Contatto(cognome, nome, telefono);
                    agenda.inserisciContatto(c);
                }
                    break;
                case 2: {
                    agenda.stampaContatti();
                }
                    break;
                case 3: {
                    System.out.println(
                            "Inserisci fedelmente il percorso di locazione del file dal quale vuoi importare i contatti: es. C:\\Desktop\\file.txt");

                    String percorso = input.next();

                    try {
                        agenda.importaContatti(percorso);
                    } catch (IOException e) {
                        System.out.println("Errore 1");
                    } catch (InputMismatchException e) {
                        System.out.println("Errore 2");
                    }
                }
                    break;
            }
        } while (scelta != 4);

        input.close();
    }
}
