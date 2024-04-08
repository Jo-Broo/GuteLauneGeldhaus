public class Konto implements IKonto {
    public Kunde Owner;
    private double kontostand;
    private String iban;
    
    public Konto(String iban, Kunde owner) 
    {
        this.iban = iban;
        this.Owner = owner;
        kontostand = 0;
    }

    public double getKontostand() 
    {
        return kontostand;
    }
    
    public String getIban() 
    {
        return iban;
    }

    public Boolean Deposit(double betrag) 
    {
        if(betrag <= 0){
            return false;
        }
        kontostand += betrag;
        return true;
    }

    public Boolean Withdraw(double betrag) 
    {
        if(betrag > this.kontostand)
        {
            return false;
        }
        kontostand -= betrag;
        return true;
    }

    public Boolean Transfer(Kunde Reciever, String to_IBAN, double amount){
        return this.Owner.Bank.Transfer(this.Owner, this.iban, Reciever, to_IBAN, amount);
    }
}
