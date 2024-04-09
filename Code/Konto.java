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

    public Boolean Deposit(double betrag) 
    {
        if(betrag <= 0){
            return false;
        }
        Balance += betrag;
        return true;
    }

    public Boolean Withdraw(double betrag) 
    {
        if(betrag > this.Balance)
        {
            return false;
        }
        Balance -= betrag;
        return true;
    }

    public Boolean Transfer(Kunde Reciever, String to_IBAN, double amount){
        return this.Owner.Bank.Transfer(this.Owner, this.Iban, Reciever, to_IBAN, amount);
    }
}
