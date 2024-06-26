import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filiale{
    public String Name;
    public String Adress;
    public List<Mitarbeiter> Employees;
    public List<Kunde> Customers;
    private double AccManagmentFee = 0.00;
    private Random random;

    public Filiale(String name, String adress){
        this.Name = name;
        this.Adress = adress;
        this.Employees = new ArrayList<Mitarbeiter>();
        this.Customers = new ArrayList<Kunde>();

        this.random = new Random();
    }

    public void AddCustomer(Person person){
        Kunde neuKunde = new Kunde(person.FirstName, person.LastName, person.Age);
        neuKunde.Bank = this;
        this.Customers.add(neuKunde);
        Mitarbeiter mitarbeiter = this.Employees.get(Math.abs(this.random.nextInt(this.Employees.size())));
        mitarbeiter.Bank = this;
        neuKunde.Consultant = mitarbeiter;
        mitarbeiter.Applicants.add(neuKunde);
        neuKunde.OpenAccount();
    }

    public void AddEmployee(Person person){
        this.Employees.add(new Mitarbeiter(person.FirstName, person.LastName, person.Age));
    }

    public boolean Transfer(Kunde Sender, String from_IBAN, Kunde Reciever, String to_IBAN, double amount)
    {
        Konto from = null;
        Konto to = null;

        if(this.Customers.contains(Reciever)){
            // Senderkonto wird gesucht
            for (Konto Account : Sender.Accounts) {
                if(Account.getIban() == from_IBAN){
                    System.out.println("[Senderkonto gefunden]");
                    from = Account;
                }
            }
            // wird das nicht gefunden dann wird der vorgang abgebrochen
            if(from == null){
                System.out.println("[Senderkonto konnte nicht gefunden werden, Vorgang wird abgebrochen]");
                return false;
            }

            // Empfängerkonto wird gesucht
            for (Konto Account : Reciever.Accounts) {
                if(Account.getIban() == to_IBAN){
                    System.out.println("[Empfängerkonto gefunden]");
                    to = Account;
                }
            }
            // wird das nicht gefunden dann wird der vorgang abgebrochen
            if(to == null){
                System.out.println("[Empfängerkonto konnte nicht gefunden werden, Vorgang wird abgebrochen]");
                return false;
            }

            System.out.print("[Transfer wird gestartet...");
            from.Withdraw(amount);
            to.Deposit(amount);
            System.out.println("Vorgang abgeschlossen]");
            
            return true;
        }

        return false;
    }

    public void getAccManagmentFee(double amount)
    {
        // Die Kontoführungsgebühr wird individuel jedem Konto abgezogen
        for (Kunde Customer : this.Customers) {
            for (Konto Account : Customer.Accounts) {
                Account.Withdraw(this.AccManagmentFee);
            }
        }
    }

    public String GenerateIBAN(){
        String IBAN = "DE00 ";
        for(int i=0;i<19;i++){
            IBAN += this.random.nextInt(9);
            if(i%4 == 0 && i != 0){
                IBAN += " ";
            }
        }
        return IBAN;
    }
}
