public class Contatto {
    
    //attributi
    private String cognome;
    private String nome;
    private String telefono;
    
    //metodo costruttore
    public Contatto(String nome, String cognome, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
    }
    
    //metodi setter e getter
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }
    
    @Override
    public String toString() {
        return "Cognome: " + cognome + "\nNome: " + nome + "\nTelefono: " + telefono;
    }
}
