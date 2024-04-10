import java.util.ArrayList;
import java.util.List;

public class Kunde extends Person{
    public List<Konto> Accounts;
    public int ID;
    public int maxAccounts = 4;
    public Filiale Bank;
    public Mitarbeiter Consultant;

    public Kunde(String fName, String lName, int age){
        super(fName, lName, age);
        this.Bank = null;
        this.Consultant = null;
        this.Accounts = new ArrayList<Konto>(maxAccounts);
    }

    public boolean OpenAccount(){
        if(this.Consultant == null){
            return false;
        }
        return this.Consultant.OpenAccount(this);
    }

    public boolean CloseAccount(Konto Account)
    {
        if(this.Consultant == null){
            return false;
        }
        if(this.Consultant.CloseAccount(Account)){
            return this.Accounts.remove(Account);
        }
        return false;
    }
    public double getBalance(String IBAN)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.getBalance();
            }
        }
        
        // Standardrückgabewert wenn kein Konto mit der entsprechenden IBAN gefunden wurde
        return 0.00;
    }
    public boolean Deposit(String IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.Deposit(amount);
            }
        }
        return false;
    }
    public boolean Withdraw(String IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == IBAN){
                return Account.Withdraw(amount);
            }
        }
        return false;
    }
    public boolean Transfer(String from_IBAN, Kunde Reciever, String to_IBAN, double amount)
    {
        for (Konto Account : this.Accounts) {
            if(Account.getIban() == from_IBAN){
                if(Account.getBalance() > amount){
                    return Account.Transfer(Reciever, to_IBAN, amount);
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
