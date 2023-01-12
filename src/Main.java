public class Main {
    public static void main(String[] args) {
        System.out.println("[+] Programma avviato con successo\n\n");

        // Aggiunge le auto
        CarSharing carSharing = new CarSharing();
        carSharing.aggiungiAutomobile("AA123BB", "Parcheggio 1");
        carSharing.aggiungiAutomobile("ST45SR8", "Parcheggio 1");
        carSharing.aggiungiAutomobile("CC45AEG", "Parcheggio 3");
        carSharing.aggiungiAutomobile("BB4NASU", "Parcheggio 3");

        // Stampo le auto
        carSharing.stampaAuto();

        System.out.println("\n");
        System.out.println("Conta auto: "+carSharing.contaAutomobili("Parcheggio 3"));
        System.out.println("Parcheggio con più auto: "+ carSharing.statistica());
    }
}