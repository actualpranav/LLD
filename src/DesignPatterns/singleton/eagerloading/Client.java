package DesignPatterns.singleton.eagerloading;

public class Client {
    public static void main(String[] args) {
        DBConnection instance = DBConnection.getInstance();
        instance.save("eagerloading message");
    }
}
