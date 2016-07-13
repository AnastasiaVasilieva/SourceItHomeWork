package Car;

import java.io.*;

/**
 * Created by Nastya on 10.06.2016.
 */
public class Cars {
    public static String fileName = "Car.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CarSerializable car1 = new CarSerializable("Ford", "7892", "diesel", 1);
        System.out.println(car1);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        out.writeObject(car1);
        out.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(fileName)));
        CarSerializable deserializCar = (CarSerializable) input.readObject();
        System.out.println(deserializCar);

        out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        CarExternalizable car2 = new CarExternalizable("Hundai", "2701", "diesel", 2);
        car2.writeExternal(out);
        out.close();
        System.out.println(car2);
        input = new ObjectInputStream(new FileInputStream(new File(fileName)));
        CarExternalizable deserializExternalCar = new CarExternalizable();
        deserializExternalCar.readExternal(input);


    }
}

