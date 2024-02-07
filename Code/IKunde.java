public interface IKunde {
    public Konto OpenAccount();
    public Boolean CloseAccount(Konto Account);
    public double getBalance(String IBAN);
    public Boolean Deposit(double amount);
    public Boolean Withdraw(double amount);
    public Boolean Transfer(Kunde Reciever, String IBAN, double amount);
}