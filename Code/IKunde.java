public interface IKunde {
    public Konto OpenAccount();
    public Boolean CloseAccount(Konto Account);
    public double getBalance(String IBAN);
    public Boolean Deposit(String IBAN, double amount);
    public Boolean Withdraw(String IBAN, double amount);
    public Boolean Transfer(String from_IBAN, Kunde Reciever, String to_IBAN, double amount);
}