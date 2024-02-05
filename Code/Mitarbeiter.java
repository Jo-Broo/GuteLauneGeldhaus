import java.util.ArrayList;
import java.util.List;

public class Mitarbeiter extends Person {
    public Filiale Bank;
    public List<Kunde> Applicants;

    public Mitarbeiter(String fName, String lName){
        super(fName, lName);
        this.Bank = null;
        this.Applicants = new ArrayList<Kunde>();
    }
}
