public interface IFiliale {
    public Boolean Transfer(Kunde Sender, String from_IBAN, Kunde Reciever, String to_IBAN, double amount);
    public void getAccManagmentFee(double amount);
}