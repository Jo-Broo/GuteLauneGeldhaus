import java.util.ArrayList;
import java.util.List;

public class Mitarbeiter extends Person implements IMitarbeiter {
    public Filiale Bank;
    public int ID;
    public List<Kunde> Applicants;

    public Mitarbeiter(String fName, String lName, int age){
        super(fName, lName, age);
        this.Bank = null;
        this.Applicants = new ArrayList<Kunde>();
    }

    // public Boolean OpenAccount(Kunde Applicant){
    //     return (Applicant.Age >= 18 && Applicant.Accounts.size() <= Applicant.maxAccounts);
    // }

    public Boolean OpenAccount(Kunde Applicant){
        if (Applicant.Age >= 18 && Applicant.Accounts.size() <= Applicant.maxAccounts){
            Applicant.Accounts.add(new Konto(this.Bank.GenerateIBAN(),Applicant));
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean CloseAccount(Konto Account){
        if(Account.getKontostand() > 0.00 || Account.getKontostand() < 0.00){
            return false;
        }
        return true;
    }
}
