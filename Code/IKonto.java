public interface IKonto {

    public double getKontostand();
    public String getIban();
    public Boolean einzahlen(double betrag); 
    public Boolean auszahlen(double betrag);
    public Boolean Transfer(Kunde Reciever, String to_IBAN, double amount);
}
