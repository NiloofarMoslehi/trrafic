import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static class User {
        String username;
        String registerDate;
    }

    static class Car {
        String plate;
    }

    static Scanner scanner;
    static ArrayList<User> users;
    static ArrayList<Car> cars;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        users = new ArrayList<>();
        cars = new ArrayList<>();
        String command = scanner.next();
        dispatchCommand(command);
    }

    public static void dispatchCommand(String command) {
        switch (command) {
            case "REGISTER":
                register();
                break;
            case "REGISTER_CAR":
                registerCar();
                break;
        }
    }

    private static void register() {
        String username = scanner.next();
        String date = scanner.next();

        Optional<User> user = findUserByUsername(username);
        if (user.isPresent()){
            System.out.println("INVALID USERNAME");
        }else{
            User u = new User();
            u.username = username;
            u.registerDate = date;
            users.add(u);
            System.out.println("REGISTER DONE");
        }
    }

    private static Optional<User> findUserByUsername(String username) {
        User result = null;
        for (User user : users) {
            if (user.username.equals(username)) {
                result = user;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

    private static void registerCar() {
        String username = scanner.next();
        String carPlate = scanner.next();
        String date = scanner.next();

        Optional<User> user = findUserByUsername(username);
        if (user.isEmpty()){
            System.out.println("INVALID USERNAME");
        }else{
            Car c = new Car();
            c.plate = carPlate;
            cars.add(c);
        }

    }


}

