public interface IKunde {
    public Boolean OpenAccount();
    public Boolean ClosAccount(String IBAN);
    public double getBalance(String IBAN);
    public Boolean Deposit(double amount);
    public Boolean Withdraw(double amount);
}