import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //It is a functional atm program where you can deposit and withdraw the money
        Scanner input = new Scanner(System.in);
        int balance = 5000;
        int chosenOption;
        boolean isRunning = true;
        int pinC = 0;
        boolean isLoggedIn = false;

        atm actualAtm = new atm(balance);

        while (isRunning) {
            System.out.println("- - - - - - - - - - - - - - - - - - -");
            System.out.println("1. - Login to your profile");
            System.out.println("2. - Create a profile");
            System.out.println("3. - Exit \n");
            System.out.print("Your chosen option is: ");
            chosenOption = input.nextInt();

            if (chosenOption == 2) {
                if (pinC == 0) {
                    boolean isRegistering = true;
                    while (isRegistering) {
                        System.out.println("Create a PIN code in order to use the service. It must be 3 digits.");
                        System.out.print("Type your pin code here: ");
                        pinC = input.nextInt();
                        if (pinC > 0 && pinC <= 999) {
                            System.out.println("The registration was successful");
                            isRegistering = false;
                        } else {
                            System.out.println("Invalid PIN code. Please try again.");
                        }
                    }
                } else {
                    System.out.println("A profile has already been created. Please log in.");
                }
            }

            if (chosenOption == 1) {
                if (isLoggedIn) {
                    System.out.println("You are already logged in.");
                } else {
                    boolean isLoggingIn = true;
                    while (isLoggingIn) {
                        System.out.println("Enter your PIN code: ");
                        int pinTry = input.nextInt();
                        if (pinTry == pinC) {
                            System.out.println("You successfully logged in!");
                            isLoggingIn = false;
                            isLoggedIn = true;
                            isRunning = false;
                        } else {
                            System.out.println("Invalid PIN code, please try again");
                        }
                    }
                }
            }
        }

        boolean isUsingATM = true;
        while (isUsingATM) {
            System.out.println("- - - - - - - - - - - - - - - - - - -");
            System.out.println("Select from the options below: \n");
            System.out.println("1 - Check Balance");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("4 - Exit \n");
            System.out.print("Your chosen option is: ");
            chosenOption = input.nextInt();

            if (chosenOption == 1) {
                actualAtm.balanceCheck();
            }

            if (chosenOption == 2) {
                System.out.print("Type the amount of money here: ");
                actualAtm.deposit(input.nextInt());
                actualAtm.balanceCheck();
            }

            if (chosenOption == 3) {
                System.out.print("Type the amount of money here: ");
                int money = input.nextInt();
                if(money < balance) {
                    actualAtm.withdraw(money);
                    actualAtm.balanceCheck();
                }
                else
                    System.out.println("Your balance is " + balance + "Ft." + " You cannot withdraw more money than you have. ");
            }

            if (chosenOption == 4) {
                System.out.println("logging out...");
                System.out.println("Have a good day!");
                isUsingATM = false;
            }
        }
    }
}

