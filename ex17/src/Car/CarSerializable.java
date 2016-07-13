package Car;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by Nastya on 14.06.2016.
 */
public class CarSerializable implements Serializable {
    private String car_model;
    private transient String car_number;
    private String car_engine;
    private transient int count;

    public CarSerializable() {
    }

    public CarSerializable(String car_model, String car_number, String car_engine, int count) {
        this.car_model = car_model;
        this.car_number = car_number;
        this.car_engine = car_engine;
        this.count = count;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_number() {
        return car_number;
    }

    public String getCar_engine() {
        return car_engine;
    }

    public int getCount() {
        return count;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        count++;
    }

    @Override
    public String toString() {
        return "Car.CarSerializable{" + "car_model=" + car_model + ", car_number=" + car_number + ", car_engine=" + car_engine + ", count=" + count + '}';
    }


}
