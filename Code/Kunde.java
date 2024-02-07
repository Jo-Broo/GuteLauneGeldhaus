import java.util.List;

public class Kunde extends Person implements IKunde{
    public List<Konto> Accounts;
    public int ID;
    private int maxAccounts = 5;
    public Filiale Bank;
    public Mitarbeiter Consultant;

    public Kunde(String fName, String lName){
        super(fName, lName);
        this.Bank = null;
        this.Consultant = null;
    }
}
