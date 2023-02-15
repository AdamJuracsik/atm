import java.util.List;

public class atm {

// INSTANCE FIELD BELOW ------------------------------------------------------------------------------------------------
 int balance;
// CONSTRUCTOR BELOW ---------------------------------------------------------------------------------------------------
    public atm(int balance) {
        this.balance = balance;
    }
// SETTERS/GETTERS BELOW------------------------------------------------------------------------------------------------
// METHODS BELOW -------------------------------------------------------------------------------------------------------
    public void  balanceCheck(){
        System.out.println("Your balance is " + balance + "Ft");
    }

    public void deposit(int depositedM){
        balance = balance + depositedM;
    }

    public void withdraw(int withDrawM){
        balance = balance - withDrawM;
    }

}
