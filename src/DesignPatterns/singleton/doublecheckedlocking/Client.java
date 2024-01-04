package DesignPatterns.singleton.doublecheckedlocking;

public class Client {
    public static void main(String[] args) {
        DBConnection instance = DBConnection.getInstance();
        instance.save("from client");
    }
}
