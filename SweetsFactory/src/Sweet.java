/**
 * Created by Nastya on 01.07.2016.
 */
public class Sweet {
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
