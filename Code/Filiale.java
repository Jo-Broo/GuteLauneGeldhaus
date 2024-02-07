import java.util.ArrayList;
import java.util.List;

public class Filiale implements IFiliale{
    public String Name;
    public String Adress;
    public String BIC;
    public List<Mitarbeiter> Employees;
    public List<Kunde> Customers;

    public Filiale(String name, String adress){
        this.Name = name;
        this.Adress = adress;
        this.Employees = new ArrayList<Mitarbeiter>();
        this.Customers = new ArrayList<Kunde>();
    }
}
