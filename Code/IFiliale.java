public interface IFiliale {
    public Boolean SendTransfer(Kunde Reciever, String IBAN, double amount);
    public Boolean GetTransfer(Kunde Reciever, String IBAN, double amount);
    public void PaySalary(double amount);
    public void getAccManagmentFee(double amount);
}
