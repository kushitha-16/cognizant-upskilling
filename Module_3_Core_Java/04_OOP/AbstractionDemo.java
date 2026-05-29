abstract class Bank {
    abstract double getInterestRate();

    void displayBankMessage() {
        System.out.println("Bank provides loan services");
    }
}

class SBI extends Bank {
    double getInterestRate() {
        return 7.5;
    }
}

class HDFC extends Bank {
    double getInterestRate() {
        return 8.2;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Bank bank1 = new SBI();
        Bank bank2 = new HDFC();

        bank1.displayBankMessage();

        System.out.println("SBI Interest Rate: " + bank1.getInterestRate() + "%");
        System.out.println("HDFC Interest Rate: " + bank2.getInterestRate() + "%");
    }
}