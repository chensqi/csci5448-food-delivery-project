package net.fooddelivery.payment.win;

public class Account {
	
	private String id;
    private double balance;
    private String name;
    private double withdraw;
    private double deposit;

    public Account(String id, double balance, String name, double withdraw, double deposit)
    {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.withdraw = withdraw;
        this.deposit = deposit;     
    }
    public Account()
    {           
    }

    public void setId(String acID)
    {
        this.id = acID; 
    }

    public void deposit(double sum)
    {
        this.balance = this.balance + sum;
    }

    public void withdraw(double sum)
    {
        this.balance = this.balance - sum;
    }

    public String getId()
    {
        return this.id;
    }

    public void setBalance(double blnc)
    {
        this.balance = blnc;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public String getName()
    {
        return this.name;
    }

        public void setName(String a)
    {
        this.name = a;
    }

    public double getWithdraw()
    {
        return this.withdraw;
    }

    public double getDeposit()
    {
        return this.deposit;
    }

    public String toString()
    {
        return " " + getId()
             + " - " + getName()
             + " - " + getBalance();
    }   

}
