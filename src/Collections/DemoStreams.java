package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStreams {
    public static class Car{
        int speed;
        int price;
        String brand;

        Car(int s, int p, String b){
            speed = s;
            price = p;
            brand = b;
        }

        @Override
        public String toString(){
            return "[Speed: " + this.speed + ", Price: " + this.price + ", Brand: " + this.brand + "]\n";
        }

        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(10, 20, 15, 18, 39, 85, 43);
            List<Integer> oddNumbers = new ArrayList<>();
            for(int v : list){
                if(v % 2 == 1) oddNumbers.add(v);
            }
            System.out.println(oddNumbers);

            Stream<Integer> streams = list.stream();
            Predicate<Integer> predicate = new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                    if(integer % 2 == 0) return true;
                    else return false;
                }
            };

            List<Integer> evenNumbers = streams.filter(predicate).collect(Collectors.toList());
            System.out.println(evenNumbers);

            Stream<Integer> s1 = list.stream();
            Predicate<Integer> predicat1 = (num) -> num % 2 == 1;
            System.out.println(list.stream().filter((num) -> num % 2 == 1).collect(Collectors.toList()));


             /*
        How Stream filter works ?

        1. Create a Stream.
        2. Stream will loop over the elements in the list.
        3. pass every value of the list to the filter method.
        4. Apply the predicate function on every list value.
        5. If the output of function on a value is true then take it, else leave it.
         */


            //map.
            List<Car> cars = Arrays.asList(
                    new Car(100, 500, "ABC"),
                    new Car(2100, 7870, "DeF"),
                    new Car(1550, 60, "ghi"),
                    new Car(70, 5000, "jkl"),
                    new Car(7800, 8000, "mno")
            );

            //Get the price of each car.
            List<Integer> prices = cars.stream().map((car) -> car.price).collect(Collectors.toList());
            System.out.println(prices);

            System.out.println(cars.stream().filter((car) -> car.price > 1000).collect(Collectors.toList()));

            System.out.println(cars.stream().map((car) -> car.price > 1000).collect(Collectors.toList()));
        }

    }
}
