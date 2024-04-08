public interface IKonto {

    public double getKontostand();
    public String getIban();
    public Boolean Deposit(double betrag); 
    public Boolean Withdraw(double betrag);
    public Boolean Transfer(Kunde Reciever, String to_IBAN, double amount);
}
