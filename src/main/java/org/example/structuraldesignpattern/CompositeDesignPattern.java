package org.example.structuraldesignpattern;

/*
https://www.youtube.com/watch?v=ZuLvHGpJSqA
https://www.geeksforgeeks.org/composite-design-pattern/
https://www.digitalocean.com/community/tutorials/composite-design-pattern-in-java
 */

import java.util.ArrayList;
import java.util.List;

interface Account{
    void showDetails();
    default double seeBalance(){
        return 0;
    }
}

class SavingBankAccount implements Account{

    private final String bankName;
    private final double balance;

    public SavingBankAccount(String bankName, double balance) {
        this.bankName = bankName;
        this.balance = balance;
    }

    @Override
    public void showDetails() {
        System.out.println(bankName + " is and balance is "+balance);
    }

    @Override
    public double seeBalance() {
        return balance;
    }
}

class CurrentBankAccount implements Account{

    private final String bankName;
    private final double balance;

    public CurrentBankAccount(String bankName, double balance) {
        this.bankName = bankName;
        this.balance = balance;
    }

    @Override
    public void showDetails() {
        System.out.println(bankName + " is and balance is "+balance);
    }

    @Override
    public double seeBalance() {
        return balance;
    }
}

class MutualFundsAccount implements Account{

    private final String fundName;
    private final double balance;

    public MutualFundsAccount(String fundName, double balance) {
        this.fundName = fundName;
        this.balance = balance;
    }

    @Override
    public void showDetails() {
        System.out.println(fundName + " is and balance is "+balance);
    }

    @Override
    public double seeBalance() {
        return balance;
    }
}

class AllFunds implements Account{

    private final List<Account> accountList;

    public AllFunds() {
        this.accountList = new ArrayList<>();
    }

    @Override
    public void showDetails() {
        accountList.forEach(Account::showDetails);
    }

    public void addFund(Account account){
        accountList.add(account);
    }

    public void removeFund(Account account){
        accountList.remove(account);
    }

    public void clearAllFunds(){
        accountList.clear();
    }

    public void showAllBalances(){
        System.out.println(accountList.stream().mapToDouble(acc -> acc.seeBalance()).sum());
    }
}

public class CompositeDesignPattern {

    public static void main(String[] args) {
        // Saving accounts
        Account sbiSavingAccount = new SavingBankAccount("SBI",9000.0);
        Account pnbSavingAccount = new SavingBankAccount("PNB",8765.3);

        // Current Account
        Account hdfcCurrentAccount = new CurrentBankAccount("HDFC",2334.1);
        Account axisCurrentAccount = new CurrentBankAccount("Axis",12.2);

        // Mutual Funds
        Account kotakMf = new MutualFundsAccount("Kotak",1200.0);


        System.out.println("===All funds details===");
        AllFunds allFunds = new AllFunds();
        allFunds.addFund(sbiSavingAccount);
        allFunds.addFund(pnbSavingAccount);
        allFunds.addFund(hdfcCurrentAccount);
        allFunds.addFund(axisCurrentAccount);
        allFunds.addFund(kotakMf);

        allFunds.showDetails();
        allFunds.showAllBalances();

    }
}
