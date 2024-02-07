public interface IKonto {

    public double getKontostand();
    public String getIban();
    public void einzahlen(double betrag); 
    public boolean auszahlen(double betrag);
}
