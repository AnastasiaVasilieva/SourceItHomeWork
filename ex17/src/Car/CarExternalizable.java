package Car;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Nastya on 14.06.2016.
 */
public class CarExternalizable implements Externalizable {
    private String car_model;
    private transient String car_number;
    private String car_engine;
    private transient int count;

    public CarExternalizable() {
    }

    public CarExternalizable(String car_model, String car_number, String car_engine, int count) {
        this.car_model = car_model;
        this.car_number = car_number;
        this.car_engine = car_engine;
        this.count = count;
    }
    public String getCar_engine() {
        return car_engine;
    }

    public int getCount() {
        return count;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getCar_number() {
        return car_number;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.car_model);
        out.writeUTF(this.car_number);
        out.writeUTF(this.car_engine);
        out.write(this.count);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readUTF();
    }
    @Override
    public String toString() {
        return "Car.CarExternalizable{" + "car_model="
                + car_model + ", car_number=" + car_number + ", car_engine=" + car_engine + ", count=" + count + '}';
    }



}
