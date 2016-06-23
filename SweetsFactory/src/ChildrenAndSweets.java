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

            System.out.println(new ChildrenAndSweets().getSweet(ChildrenAndSweets.SweetType.ICECREAM));
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

            System.out.println(new ChildrenAndSweets().getSweet(ChildrenAndSweets.SweetType.CAKE));
        }
    }
}

public class ChildrenAndSweets {
    static ChildrenCake cake;
    static ChildrenIceCream icecream;

    public static Sweet getSweet(SweetType type) {
        switch (type) {
            case CANDY:
                return new Candy("Candy", "cherry", "red");
            case ICECREAM:
                return new IceCream("Ice-cream", "banana", "yellow");
            case CAKE:
                return new Cake("Cake", "chocko", "brown");
        }
        return null;
    }

    public static void main(String[] args) {
        cake = new ChildrenCake();
        icecream = new ChildrenIceCream();
        System.out.println("start asking sweets");
        cake.start();
        icecream.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            System.out.println(new ChildrenAndSweets().getSweet(SweetType.CANDY));
        }
        if (icecream.isAlive())    //проверка завершения предыдущего потока
        {
            try {
                icecream.join();    //Подождать пока закончит выпрашивать сладости.
            } catch (InterruptedException e) {
            }

            System.out.println(new ChildrenAndSweets().getSweet(SweetType.ICECREAM));
        } else    //если предыдущий поток завершился
        {
            System.out.println(new ChildrenAndSweets().getSweet(SweetType.CANDY));
        }
        System.out.println("Finish");
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
