import java.util.ArrayList;
import java.util.List;

public class Filiale implements IFiliale{
    public String Name;
    public String Adress;
    public String BIC;
    public List<Mitarbeiter> Employees;
    public List<Kunde> Customers;
    private double AccManagmentFee = 0.00;

    public Filiale(String name, String adress){
        this.Name = name;
        this.Adress = adress;
        this.Employees = new ArrayList<Mitarbeiter>();
        this.Customers = new ArrayList<Kunde>();
    }

    
    public Boolean Transfer(Kunde Sender, String from_IBAN, Kunde Reciever, String to_IBAN, double amount)
    {
        Konto from = null;
        Konto to = null;

        if(this.Customers.contains(Reciever)){

            // Die beiden Konten werden ermittelt wenn am ende eines nicht gefunden wurde wird die Überweisung abgebrochen
            // !wichtig! die bearbeitung der Kontostände wird erst am Ende vorgenommen

            for (Konto Account : Sender.Accounts) {
                if(Account.getIban() == from_IBAN){
                    from = Account;
                }
            }
            for (Konto Account : Reciever.Accounts) {
                if(Account.getIban() == to_IBAN){
                    to = Account;
                }
            }

            if(from == null || to == null){return false;}
            from.auszahlen(amount);
            to.einzahlen(amount);
            
            return true;
        }
        return false;
    }

    public void getAccManagmentFee(double amount)
    {
        // Die Kontoführungsgebühr wird individuel jedem Konto abgezogen
        for (Kunde Customer : this.Customers) {
            for (Konto Account : Customer.Accounts) {
                Account.auszahlen(this.AccManagmentFee);
            }
        }
    }
}
