public class Program {
    public static void main(String[] args){
        Filiale Bank = new Filiale("null", "null");

        Bank.AddEmployee(new Person("Jonas", "Wolf", 20));

        Mitarbeiter Jonas = Bank.Employees.get(0);
        Bank.AddEmployee(new Person("Cornelius", "Mueller", 22));
        Mitarbeiter Cornelius = Bank.Employees.get(1);

        Bank.AddCustomer(new Person("Niklas", "Soika", 21));
        Kunde Niklas = Bank.Customers.get(0);
        Bank.AddCustomer(new Person("Floarian","Diehle", 20));
        Kunde Florian = Bank.Customers.get(1);

        // Generell muss man noch das Fehler Management machen gerade gibts halt nur unhandeld exceptions

        // Diese zwei Zeilen kann man noch in eine logische Methode zusammenfassen vlt. als Setter beim Mitarbeiter
        // Das der Mitarbeiter sowas hat wie MItarbeiter.getNewKunde()
        // und da wird beim Kunden direkt der Mitarbeiter gesetzt
        // === Mitarbeiter-Kunden beziehung
        // Niklas.Consultant = Jonas;
        // Jonas.Applicants.add(Niklas);
        // Jonas.Bank = Bank;
        // Niklas.Bank = Bank;

        // Florian.Consultant = Cornelius;
        // Cornelius.Applicants.add(Florian);
        // Cornelius.Bank = Bank;
        // Florian.Bank = Bank;

        // Bank.Employees.add(Cornelius);
        // Bank.Employees.add(Jonas);
        // Bank.Customers.add(Niklas);
        // Bank.Customers.add(Florian);

        System.out.println("=== Mitarbeiter - Kundenbeziehungen ===");
        for (Mitarbeiter mitarbeiter : Bank.Employees) {
            System.out.println("Zu betreuende Kunden von " + mitarbeiter.FirstName + " " + mitarbeiter.LastName + ":");
            for (Kunde kunde : mitarbeiter.Applicants) {
                System.out.println(kunde.FirstName + " " + kunde.LastName);
            }
        }
        // System.out.println("== Kundenbeziehung zwischen Jonas und Niklas wird aufgebaut ==");
        // System.out.println("1. Kunde von Jonas: " + Jonas.Applicants.get(0).FirstName + " " + Jonas.Applicants.get(0).LastName);
        // System.out.println("Bearbeiter von Niklas: " + Niklas.Consultant.FirstName + " " + Niklas.Consultant.LastName);
        // ===
        
        // === Account erstellung
        System.out.println("=== === === === === === ===");
        System.out.println("Niklas hat gerade " + Niklas.Accounts.size() + " Konten.");
        System.out.println("Niklas beantragt ein Konto.");
        Niklas.OpenAccount();
        System.out.println("Niklas hat jetzt " + Niklas.Accounts.size() + " Konten.");
        System.out.println("Die IBAN lautet: " + Niklas.Accounts.get(0).getIban());
        System.out.println("=== === === === === === ===");

        System.out.println("Florian hat gerade " + Florian.Accounts.size() + " Konten.");
        System.out.println("Florian beantragt ein Konto.");
        Florian.OpenAccount();
        System.out.println("Florian hat jetzt " + Florian.Accounts.size() + " Konten.");
        System.out.println("Die IBAN lautet: " + Florian.Accounts.get(0).getIban());
        System.out.println("=== === === === === === ===");
        // === 

        // === Account Management
        System.out.println("=== === === === === === ===");
        System.out.println("Niklas hat auf seinem 1. Konto einen Kontostand von: " + Niklas.Accounts.get(0).getBalance());
        System.out.println("Niklas zahlt 100 ein.");
        Niklas.Accounts.get(0).Deposit(100);
        System.out.println("Niklas hat auf seinem 1. Konto jetzt einen Kontostand von: " + Niklas.Accounts.get(0).getBalance());
        System.out.println("Niklas hebt er 12.64 ab");
        Niklas.Accounts.get(0).Withdraw(12.64);
        System.out.println("Niklas hat auf seinem 1. Konto jetzt einen Kontostand von: " + Niklas.Accounts.get(0).getBalance());
        System.out.println("=== === === === === === ===");
        // ===

        // === Überweisen
        System.out.println("Niklas möchte Florian 86.36 überweisen.");
        Niklas.Transfer(Niklas.Accounts.get(0).getIban(), Florian, Florian.Accounts.get(0).getIban(), 186.36);
        System.out.println("Niklas hat jetzt " + Niklas.Accounts.get(0).getBalance() + " auf seinem Konto.");
        System.out.println("Florian hat jetzt " + Florian.Accounts.get(0).getBalance() + " auf seinem Konto.");
        // ===

        // === Account löschen
        System.out.println("=== === === === === === ===");
        System.out.println("Niklas möchte jetzt sein Konto löschen.");
        if(Niklas.CloseAccount(Niklas.Accounts.get(0))){
            System.out.println("Der Vorgang war erfolgreich.");
        }
        else{
            System.out.println("Der Vorgang war nicht erfolgreich.");
        }
        System.out.println("Niklas hebt den verbleibenden Betrag ab und versucht es erneut.");
        Niklas.Accounts.get(0).Withdraw(1);
        if(Niklas.CloseAccount(Niklas.Accounts.get(0))){
            System.out.println("Der Vorgang war erfolgreich.");
        }
        else{
            System.out.println("Der Vorgang war nicht erfolgreich.");
        }
        System.out.println("=== === === === === === ===");
        // ===
    }
}