import entities.Hotel;
import entities.User;

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel(111, "Hello", "Kiev", 11212, 2, 400, new User(111, "Vasya", "Pupkin"));



        System.out.println(hotel.toString());
        System.out.println("Hello world!");
    }

    public int test() {
        return 1;
    }

}
