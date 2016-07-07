/**
 * Created by Nastya on 22.06.2016.
 */
public class ChildrenAndSweets {
    private static volatile long lastTime;
    public static synchronized Sweet getSweet(SweetType type) {
        if (System.currentTimeMillis() - lastTime > 1000) {
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

    public static int waitforSweet(Sweet sweet, int i){
        if(sweet!=null)
            System.out.println(sweet);
        else{
            System.out.println("wait for sweet");
            i--;
        }
        return i;
    }
}
