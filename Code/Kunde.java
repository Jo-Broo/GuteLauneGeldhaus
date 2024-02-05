import java.util.List;

public class Kunde extends Person {
    public List<Konto> Accounts;
    private int maxAccounts = 5;
    public Filiale Bank;
    public Mitarbeiter Consultant;

    public Kunde(String fName, String lName){
        super(fName, lName);
        this.Bank = null;
        this.Consultant = null;
    }
}
