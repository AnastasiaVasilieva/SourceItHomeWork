package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nastya on 27.07.2016.
 */
public class InstantLottery implements Lottery {
    /**
      Тип - мгновенная
     - номер лотереи
    - тип
    - билеты участвующие в розыграше
    - провести розыграш
    - выиграшные комбинации
    - забрать выиграш
     */
    Random rand = new Random();
    List<Ticket> tickets = new ArrayList<Ticket>();
    private int[][] winCombinations = new int[1][1];
    private Long lotteryNumber = 1l;
    public Double money = 0d;


    @Override
    public Long getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public Type getType() {
        return Type.INSTANT;
    }

    @Override
    public List<Ticket> getLotteryTickets() {
        return tickets;
    }

    @Override
    public void performLottery() {
        winCombinations[0][0] = rand.nextInt(1000);
    }

    @Override
    public int[][] getWinCombinations() {
        return winCombinations;
    }

    @Override
    public Double takeMoney(Ticket ticket) {
        return money;
    }

}