/**
 * Created by Nastya on 22.06.2016.
 */
class ChildrenIceCream extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                }
            ChildrenAndSweets.Sweet sweet = ChildrenAndSweets.getSweet(ChildrenAndSweets.SweetType.ICECREAM);
            if(sweet!=null)
            System.out.println(sweet);
            else{
                System.out.println("wait for sweet");
                i--;
            }
            }
    }
}
class ChildrenCake extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            ChildrenAndSweets.Sweet sweet = ChildrenAndSweets.getSweet(ChildrenAndSweets.SweetType.CAKE);
            if(sweet!=null)
            System.out.println(sweet);
            else{
                System.out.println("wait for sweet");
                i--;
            }
        }
    }
}
class ChildrenCandy extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            ChildrenAndSweets.Sweet sweet = ChildrenAndSweets.getSweet(ChildrenAndSweets.SweetType.CANDY);
            if(sweet!=null)
                System.out.println(sweet);
            else{
                System.out.println("wait for sweet");
                i--;
            }
        }
    }
}
public class ChildrenAndSweets {
    private static volatile long lastTime;

    public static synchronized Sweet getSweet(SweetType type) {
        if(System.currentTimeMillis() - lastTime > 1000)
        {
            lastTime = System.currentTimeMillis();
            switch (type) {
                case CANDY:
                    return new Candy("Candy", "cherry", "red");
                case ICECREAM:
                    return new IceCream("Ice-cream", "banana", "yellow");
                case CAKE:
                    return new Cake("Cake", "chocko", "brown");
            }
        }

        return null;
    }
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
    enum SweetType {
        ICECREAM, CANDY, CAKE;
    }
    static class Sweet {
        public String taste;
        public String color;
        public String name;

        public Sweet(String name, String taste, String color) {
            this.name = name;
            this.taste = taste;
            this.color = color;
        }

        @Override
        public String toString() {
            return name + "{" + "taste = " + taste + ", color = " + color + '}';
        }
    }
    static class Candy extends Sweet {

        public Candy(String name, String taste, String color) {
            super(name, taste, color);
        }
    }
    static class IceCream extends Sweet {

        public IceCream(String name, String taste, String color) {
            super(name, taste, color);
        }
    }
    static class Cake extends Sweet {
        public Cake(String name, String taste, String color) {
            super(name, taste, color);
        }
    }
}
