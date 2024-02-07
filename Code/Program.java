import java.io.Console;

public class Program {
    public static void main(String[] args){
        Kunde Florian = new Kunde("Floarian","Diehle", 19);
        Kunde Niklas = new Kunde("Niklas", "Soika", 21);
        Mitarbeiter Cornelius = new Mitarbeiter("Cornelius", "Mueller", 22);
        Mitarbeiter Jonas = new Mitarbeiter("Jonas", "Wolf", 22);

        Filiale Bank = new Filiale("null", "null");

        // Generell muss man noch das Fehler Management machen gerade gibts halt nur unhandeld exceptions

        // Diese zwei Zeilen kann man noch in eine logische Methode zusammenfassen vlt. als Setter beim Mitarbeiter
        // Das der Mitarbeiter sowas hat wie MItarbeiter.getNewKunde()
        // und da wird beim Kunden direkt der Mitarbeiter gesetzt
        // === Mitarbeiter-Kunden beziehung
        Niklas.Consultant = Jonas;
        Jonas.Applicants.add(Niklas);
        Jonas.Bank = Bank;
        Niklas.Bank = Bank;

        Florian.Consultant = Cornelius;
        Cornelius.Applicants.add(Florian);
        Cornelius.Bank = Bank;
        Florian.Bank = Bank;

        System.out.println(Jonas.Applicants.get(0).FirstName);
        System.out.println(Niklas.Consultant.FirstName + " " + Niklas.Consultant.LastName);
        // ===
        
        // === Account erstellung
        System.out.println(Niklas.Accounts.size());
        Konto neu = Niklas.OpenAccount();
        if(neu != null){
            Niklas.Accounts.add(neu);
        }
        System.out.println(Niklas.Accounts.size());
        neu = Florian.OpenAccount();
        if(neu != null){
            Florian.Accounts.add(neu);
        }
        // === 

        // === Account Management
        Niklas.Accounts.get(0).einzahlen(100);
        System.out.println(Niklas.Accounts.get(0).getKontostand());
        // Niklas.Accounts.get(0).auszahlen(23.76);
        // System.out.println(Niklas.Accounts.get(0).getKontostand());
        // ===

        // === Account löschen
        // System.out.println(Niklas.Accounts.size());
        // System.out.println(Niklas.CloseAccount(Niklas.Accounts.get(0)));
        // ===

        // === Überweisen
        Niklas.Accounts.get(0).Transfer(Florian, " ", 10.01);
        System.out.println(Florian.Accounts.get(0).getKontostand());
        // ===
    }
}
