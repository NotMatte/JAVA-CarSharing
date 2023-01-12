public class Automobile {
    private String targa;
    private int viaggi;
    private Parcheggio locazione;

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public int getViaggi() {
        return viaggi;
    }

    public void setViaggi(int viaggi) {
        this.viaggi = viaggi;
    }

    public Parcheggio getLocazione() {
        return locazione;
    }

    public void setLocazione(Parcheggio locazione) {
        this.locazione = locazione;
    }

    public Automobile(String targa, Parcheggio locazione){
        this.targa = targa;
        this.viaggi = 0;
        this.locazione = locazione;
    }
}
