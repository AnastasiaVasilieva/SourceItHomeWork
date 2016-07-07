/**
 * Created by Nastya on 01.07.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        ChildrenCake cake = new ChildrenCake();
        ChildrenIceCream icecream = new ChildrenIceCream();
        ChildrenCandy candy = new ChildrenCandy();
        System.out.println("start asking sweets");
        cake.start();
        icecream.start();
        candy.start();
        cake.join();
        icecream.join();
        candy.join();
    }
}
