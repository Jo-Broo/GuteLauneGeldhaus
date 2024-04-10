public class Program {
    public static void main(String[] args){
        //initialisierung
        Filiale Bank = new Filiale("GuteLauneGeldhaus", "Talstraße 69, 71069 Sindelfingen");

        System.out.println("=== Vorführprogramm der " + Bank.Name + " Bank ===");

        Person p1 = new Person("Jonas", "Wolf", 20);
        Bank.AddEmployee(p1);
        Mitarbeiter Jonas = getMitarbeiter(Bank, p1.FirstName, p1.LastName);

        Person p2 = new Person("Cornelius", "Mueller", 22);
        Bank.AddEmployee(p2);
        Mitarbeiter Cornelius = getMitarbeiter(Bank, p2.FirstName, p2.LastName);

        Bank.AddCustomer(new Person("Niklas", "Soika", 21));
        Kunde Niklas = Bank.Customers.get(0);
        Bank.AddCustomer(new Person("Floarian","Diehle", 20));
        Kunde Florian = Bank.Customers.get(1);

        System.out.println("=== Mitarbeiter - Kundenbeziehungen ===");
        for (Mitarbeiter mitarbeiter : Bank.Employees) {
            System.out.println("Zu betreuende Kunden von " + mitarbeiter.FirstName + " " + mitarbeiter.LastName + ":");
            for (Kunde kunde : mitarbeiter.Applicants) {
                System.out.println(kunde.FirstName + " " + kunde.LastName);
            }
        }
        System.out.println("=== === === === === === ===");
        // ===
        
        // === Account erstellung
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
        System.out.println("Niklas Kontostand des 1. Kontos: " + Niklas.Accounts.get(0).getBalance());
        System.out.println("Florian Kontostand des 1. Kontos: " + Florian.Accounts.get(0).getBalance());

        System.out.println("Niklas überweist Florian 86.36.");
        Niklas.Transfer(Niklas.Accounts.get(0).getIban(), Florian, Florian.Accounts.get(0).getIban(), 86.36);
        //Niklas.Transfer(Niklas.Accounts.get(0).getIban(), Florian, "DE4712345678123412", 86.36);
        
        System.out.println("Niklas Kontostand des 1. Kontos: " + Niklas.Accounts.get(0).getBalance());
        System.out.println("Florian Kontostand des 1. Kontos: " + Florian.Accounts.get(0).getBalance());
        System.out.println("=== === === === === === ===");
        // ===

        // === Account löschen
        System.out.println("Niklas möchte jetzt sein 1. Konto löschen.");
        if(Niklas.CloseAccount(Niklas.Accounts.get(0))){
            System.out.println("Der Vorgang war erfolgreich.");
        }
        else{
            System.out.println("Der Vorgang war nicht erfolgreich.");
        }
        System.out.println("Niklas hebt den verbleibenden Betrag ab und versucht es erneut.");
        Niklas.Accounts.get(0).Withdraw(Niklas.Accounts.get(0).getBalance());
        if(Niklas.CloseAccount(Niklas.Accounts.get(0))){
            System.out.println("Der Vorgang war erfolgreich.");
        }
        else{
            System.out.println("Der Vorgang war nicht erfolgreich.");
        }
        System.out.println("=== === === === === === ===");
        System.out.println("=== Ende des Programms ===");
        System.out.println("Besuchen sie uns gern vor Ort in der " + Bank.Adress);
        // ===
    }

    public static Mitarbeiter getMitarbeiter(Filiale Bank, String fName, String lName) {
        return Bank.Employees.stream()
        .filter(employee -> employee.FirstName.toLowerCase() == fName.toLowerCase() && employee.LastName.toLowerCase() == lName.toLowerCase())
        .findFirst()
        .orElse(null);
    }
}