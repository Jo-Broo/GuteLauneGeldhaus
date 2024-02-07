public class Konto implements IKonto {
    public Kunde Owner;
    private double kontostand;
    private String iban;
    
    public Konto(String iban) 
    {
        this.iban = iban;
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

    public void einzahlen(double betrag) 
    {
        kontostand += betrag;
    }

    public boolean auszahlen(double betrag) 
    {
        if(betrag > this.kontostand)
        {
            return false;
        }
        kontostand -= betrag;
        return true;
    }
}
