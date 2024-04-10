public class Konto{
    public Kunde Owner;
    private double Balance;
    private String Iban;
    
    public Konto(String iban, Kunde owner) 
    {
        this.Iban = iban;
        this.Owner = owner;
        Balance = 0;
    }

    public double getBalance() 
    {
        return Balance;
    }
    
    public String getIban() 
    {
        return Iban;
    }

    public boolean Deposit(double betrag) 
    {
        if(betrag <= 0){
            return false;
        }
        Balance += betrag;
        return true;
    }

    public boolean Withdraw(double betrag) 
    {
        if(betrag > this.Balance)
        {
            return false;
        }
        Balance -= betrag;
        return true;
    }

    public boolean Transfer(Kunde Reciever, String to_IBAN, double amount){
        return this.Owner.Bank.Transfer(this.Owner, this.Iban, Reciever, to_IBAN, amount);
    }
}
