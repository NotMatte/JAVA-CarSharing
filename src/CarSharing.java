import java.util.ArrayList;

public class CarSharing {
    private ArrayList<Parcheggio> parcheggi;
    private ArrayList<Automobile> automobili;

    public CarSharing(){
        this.parcheggi = new ArrayList<Parcheggio>();
        this.automobili = new ArrayList<Automobile>();
    }

    public ArrayList<Parcheggio> getParcheggi(){ return parcheggi; }
    public void setParcheggi(ArrayList<Parcheggio> parcheggi){ this.parcheggi = parcheggi; }

    public ArrayList<Automobile> getAutomobili(){ return automobili; }
    public void setAutomobili(ArrayList<Automobile> automobili){ this.automobili = automobili; }

    // --- Metodi
    public void aggiungiParcheggio(String unNome){
        for(Parcheggio p: parcheggi){
            if(p.getNome().equals(unNome)){
                return;
            }
        }
        Parcheggio nuovoParcheggio = new Parcheggio(unNome);
        parcheggi.add(nuovoParcheggio);
    }

    public void aggiungiAutomobile(String unaTarga, String unNomeParcheggio){
        for(Automobile a: automobili){
            if(a.getTarga().equals(unaTarga)){
                return;
            }
        }
        aggiungiParcheggio(unNomeParcheggio);
        for(Parcheggio p: parcheggi){
            if(p.getNome().equals(unNomeParcheggio)){
                Automobile auto = new Automobile(unaTarga, p);
                automobili.add(auto);
            }
        }
    }

    public void transito(String unaTarga, String parcheggioArrivo){
        for(Automobile a: automobili){
            if(a.getTarga().equals(unaTarga)){
                aggiungiParcheggio(parcheggioArrivo);
                for(Parcheggio p: parcheggi){
                    if(p.getNome().equals(parcheggioArrivo)){
                        a.setLocazione(p);
                        a.setViaggi(a.getViaggi() + 1);
                        System.out.println("(/) Auto targata "+ unaTarga + " spostata con successo su: "+ parcheggioArrivo);
                    }
                }
            }
        }
    }

    public int contaAutomobili(String unNomeParcheggio){
        int count = 0;
        for(Automobile a: automobili){
            if(a.getLocazione().getNome().equals(unNomeParcheggio)){ count++; }
        }
        return count;
    }

    public void rimuoviAutomobili(int unNumeroViaggi){
        for(Automobile a: automobili){
            if(a.getViaggi() >= unNumeroViaggi){
                automobili.remove(a);
            }
        }
    }

    public String statistica(){
        // Restituisci il parcheggio con più macchine al suo interno
        String parcheggioConPiuAuto = "";
        int maxAuto = 0;

        // Controllo se non ci sono auto e faccio il return se non ci sono
        if(automobili.size() == 0){
            return "n/a";
        }

        // Controlli passati
        for(Parcheggio p: parcheggi){
            int count = 0;
            for(Automobile a: automobili){
                if(a.getLocazione().getNome().equals(p.getNome())){
                    count++;
                }
            }
            if(count > maxAuto){
                maxAuto = count;
                parcheggioConPiuAuto = p.getNome();
            }
        }
        return parcheggioConPiuAuto;
    }

    // Stampa le auto
    public void stampaAuto(){
        // Controllo se non ci sono auto e faccio il return se non ci sono
        if(automobili.size() == 0){
            System.out.println("[ERR] Non ci sono auto da mostrare, i parcheggi sono vuoti.");
            return;
        }

        for(Automobile a: automobili){
            System.out.println("Targa: " + a.getTarga() + " - Parcheggio: " + a.getLocazione().getNome());
        }
    }
}
