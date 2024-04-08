public interface IFiliale {
    public void AddCustomer(Person person);
    public void AddEmployee(Person person);
    public Boolean Transfer(Kunde Sender, String from_IBAN, Kunde Reciever, String to_IBAN, double amount);
    public void getAccManagmentFee(double amount);
    public String GenerateIBAN();
}