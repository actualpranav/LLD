package DesignPatterns.adapter;

public class Client {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe();

        phonePe.getBalance();
        phonePe.doTransaction("A", "B", 20);
    }
}
