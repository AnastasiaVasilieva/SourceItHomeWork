/**
 * Created by Nastya on 07.07.2016.
 */
class ChildrenCandy extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
            ChildrenAndSweets.waitforSweet(ChildrenAndSweets.getSweet(SweetType.CANDY), i);
        }
    }
}