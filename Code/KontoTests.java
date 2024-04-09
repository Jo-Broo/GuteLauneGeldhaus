import org.junit.Assert;
import org.junit.Test;

public class KontoTests {
    @Test
    public void KundeKontoerstellenTrue(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        
        // Act
        kunde.OpenAccount();

        // Assert
        Assert.assertTrue(kunde.Accounts.size() == 1);
    }

    @Test
    public void KundeKontolöschenTrue(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        
        // Act
        kunde.OpenAccount();

        // Assert
        Assert.assertTrue(kunde.CloseAccount(kunde.Accounts.get(0)));
    }

    @Test
    public void KundeKontoerstellenFalse(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        
        // Act
        kunde.OpenAccount(); // 1. Konto
        kunde.OpenAccount(); // 2. Konto
        kunde.OpenAccount(); // 3. Konto
        kunde.OpenAccount(); // 4. Konto
        kunde.OpenAccount(); // 5. Konto

        // Assert
        Assert.assertTrue(!kunde.OpenAccount()); // 6. Konto
    }

    @Test
    public void KundeEinzahlenTrue(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        kunde.OpenAccount();
        
        // Act
        // Assert
        Assert.assertTrue(kunde.Accounts.get(0).Deposit(13.67));
        Assert.assertTrue(kunde.Accounts.get(0).getBalance() == 13.67);
    }

    @Test
    public void KundeEinzahlenFalse(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        kunde.OpenAccount();
        
        // Act
        // Assert
        Assert.assertTrue(!kunde.Accounts.get(0).Deposit(-13.24));
        Assert.assertTrue(kunde.Accounts.get(0).getBalance() == 0.0);
    }

    @Test
    public void KundeAbhebenTrue(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        kunde.OpenAccount();
        kunde.Accounts.get(0).Deposit(100);
        
        // Act
        // Assert
        Assert.assertTrue(kunde.Accounts.get(0).Withdraw(67.31));
        Assert.assertTrue(kunde.Accounts.get(0).getBalance() == 32.69);
    }

    @Test
    public void KundeAbhebenFalse(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        Kunde kunde = filiale.Customers.get(0);
        kunde.OpenAccount();
        
        // Act
        // Assert
        Assert.assertTrue(!kunde.Accounts.get(0).Withdraw(10));
        Assert.assertTrue(kunde.Accounts.get(0).getBalance() == 0.00);
    }

    @Test
    public void KundeÜberweisenTrue(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        filiale.AddCustomer(new Person("Leon", "Mustermann", 20));
        Kunde Max = filiale.Customers.get(0);
        Kunde Leon = filiale.Customers.get(1);
        Max.OpenAccount();
        Leon.OpenAccount();

        // Act
        Max.Accounts.get(0).Deposit(13);

        // Assert
        Assert.assertTrue(Max.Transfer(Max.Accounts.get(0).getIban(), Leon, Leon.Accounts.get(0).getIban(), 13));
        Assert.assertTrue(Leon.Accounts.get(0).getBalance() == 13.00);
    }

    @Test
    public void KundeÜberweisenFalse(){
        // Arrange
        Filiale filiale = new Filiale("Musterbank", "Musterstraße");
        filiale.AddEmployee(new Person("Erika", "Mustermann", 20));
        filiale.AddCustomer(new Person("Max", "Mustermann", 20));
        filiale.AddCustomer(new Person("Leon", "Mustermann", 20));
        Kunde Max = filiale.Customers.get(0);
        Kunde Leon = filiale.Customers.get(1);
        Max.OpenAccount();
        Leon.OpenAccount();

        // Act
        Max.Accounts.get(0).Deposit(13);

        // Assert
        Assert.assertTrue(!Max.Transfer(Max.Accounts.get(0).getIban(), Leon, Leon.Accounts.get(0).getIban(), 14));
        Assert.assertTrue(Leon.Accounts.get(0).getBalance() == 0.00);
    }
}