package grosery;
public class grosary
{
    private String Customer_Name; 
    private String Customer_ID;
    private String Customer_phone;
    private String address;
    private double accountbalance;

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(String customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_phone() {
        return Customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        Customer_phone = customer_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(double accountbalance) {
        this.accountbalance = accountbalance;
    }

    public void shop(double amount){
        if (accountbalance >= amount){
            double remaningbalance=accountbalance-amount;
            System.out.println("thanks for shopping \n ");
            System.out.println("your balance is : "+remaningbalance);
            accountbalance = remaningbalance;
        }
        else{
            double lowamount = accountbalance - amount;
            System.out.println("insufficient balance, add more !"+lowamount);
        }
    }

    public void recharge(double recharge){
        accountbalance = accountbalance + recharge;
        System.out.println("your new balance is : "+accountbalance);
    }
}