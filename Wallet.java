public class Wallet {
    private double balance;

    public Wallet(){
        setBalance(0);
    }

    public Wallet(double n){
        setBalance(n);
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addBalance(double price){
        setBalance(this.balance+price);
    }
}
