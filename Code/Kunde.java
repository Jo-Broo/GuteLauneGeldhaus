import java.util.ArrayList;
import java.util.List;

public class Kunde extends Person implements IKunde{
    public List<Konto> Accounts;
    public int ID;
    public int maxAccounts = 5;
    public Filiale Bank;
    public Mitarbeiter Consultant;

    public Kunde(String fName, String lName, int age){
        super(fName, lName, age);
        this.Bank = null;
        this.Consultant = null;
        this.Accounts = new ArrayList<Konto>(maxAccounts);
    }

    public Konto OpenAccount(){
        if(this.Consultant.OpenAccount(this)){
            Konto neu = new Konto("");
            neu.Owner = this;
            return neu; // funktion schreiben zum IBAN generieren 
        }
        return null;
    }

    public Boolean CloseAccount(Konto Account)
    {
        if(this.Consultant.CloseAccount(Account)){
            return this.Accounts.remove(Account);
        }
        return false;
    }
    public double getBalance(String IBAN)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.getKontostand();
            }
        }
        // hier muss noch eine andere Lösung gefunden werden sowas wie einen out-Parameter gibts leider nicht
        // vlt über eine objekt rückgabe des Statuses 
        return 0.00;
    }
    public Boolean Deposit(String IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.einzahlen(amount);
            }
        }
        return false;
    }
    public Boolean Withdraw(String IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.auszahlen(amount);
            }
        }
        return false;
    }
    public Boolean Transfer(String from_IBAN, Kunde Reciever, String to_IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == from_IBAN){
                return Account.Transfer(Reciever, to_IBAN, amount);
            }
        }
        return false;
    }
}
