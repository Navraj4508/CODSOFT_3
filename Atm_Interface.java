package ATM;

import java.util.Scanner;

/*

1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.*/

class Bankaccount{
	private double Balance;
	public Bankaccount(double pre_Balance) {
		this.Balance=pre_Balance;
	}
	public double getBalance() {
		return Balance;
	}
	
	public void deposit (double amount) {
		if(amount>0) {
			Balance += amount;
			System.out.println("Deposit Successful! your balance is: "+Balance);
		}else {
			System.out.println("Invalid Deposit Amount:");
		}
	}
	public void withdraw(double amount) {
		if(amount>0 && amount<=Balance) {
			Balance -= amount;
			System.out.println("Withdrawal Successful! your balance is: "+Balance);
		}
		else {
			System.out.println("Invalid Amount: "+amount);
		}
	}
}

class ATM{
	private Bankaccount account;
	
	public ATM(Bankaccount account) {
		this.account = account;
	}
	
	public void DisplayMenu() {
		System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
	}
	
	public void processOption(int option , double amount) {
		
		switch (option){ 
			case 1: 
				account.withdraw(amount);
				break;
			case 2: 
				account.deposit(amount);
				break;
			case 3:
				System.out.println("your Current Balances: "+account.getBalance());
				break;
			default:
					System.out.println("Invalid Option!");
		}	
		
	}
}


public class Atm_Interface {
	public static void main(String[] args) {
		Bankaccount useraccount = new Bankaccount(1000.0); // previous balances:
		ATM atm = new ATM(useraccount);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			atm.DisplayMenu();
			
			System.out.println("Enter the option(1/2/3):");
			int option = sc.nextInt();
			
			if(option ==1 || option == 2) {
				System.out.println("Enter Amount: ");
				double amount = sc.nextDouble();
				atm.processOption(option, amount);
			}else if(option==3){
				atm.processOption(option,0);
			}else {
				System.out.println("Invalid option: exit");
				break;
			}
		}
		 sc.close();
	}
	
}


