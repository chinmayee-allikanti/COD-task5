package com.codtech;
import java.util.Scanner;

public class Banking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails[] customers = new BankDetails[n];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new BankDetails();
            customers[i].openAccount();
        }

        int choice;
        do {
            System.out.println("\n*** Banking System Application ***");
            System.out.println("1. Display all account details");
            System.out.println("2. Search by Account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. transcation details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (BankDetails customer : customers) {
                        customer.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (BankDetails customer : customers) {
                        found = customer.search(ac_no);
                        if (found) break;
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account no. to deposit: ");
                    ac_no = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(ac_no)) {
                            customer.deposit();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account no. to withdraw: ");
                    ac_no = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(ac_no)) {
                            customer.withdrawal();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter source account no.: ");
                    String src_ac_no = sc.next();
                    System.out.print("Enter target account no.: ");
                    String target_ac_no = sc.next();

                    BankDetails srcAccount = null;
                    BankDetails targetAccount = null;

                    for (BankDetails customer : customers) {
                        if (customer.search(src_ac_no)) {
                            srcAccount = customer;
                        }
                        if (customer.search(target_ac_no)) {
                            targetAccount = customer;
                        }
                    }

                    if (srcAccount != null && targetAccount != null) {
                        srcAccount.transfer(targetAccount);
                    } else {
                        System.out.println("Source or target account not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 6);
    }
}
