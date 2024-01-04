package DesignPatterns.singleton.simple;

public class Client {
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.save("connection saved");
    }
}
