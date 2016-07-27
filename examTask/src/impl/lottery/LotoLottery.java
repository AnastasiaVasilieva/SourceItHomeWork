package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nastya on 27.07.2016.
 */
public class LotoLottery implements Lottery {
    public Double money;
    /**
     * Тип - лото
     * - номер лотереи
     * - тип
     * - билеты участвующие в розыграше
     * - провести розыграш
     * - выиграшные комбинации
     * - забрать выиграш
     */
    List<Ticket> tickets = new ArrayList<Ticket>();
    Random rand = new Random();
    private Long lotteryNumber = 0l;
    private int[][] winCombinations = new int[4][4];

    @Override
    public Long getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public Type getType() {
        return Type.LOTTO;
    }

    @Override
    public void performLottery() {
        for (int i = 0; i < winCombinations.length; i++) {
            for (int j = 0; j < winCombinations[i].length; j++) {
                winCombinations[i][j] = rand.nextInt(40);
            }
        }
    }

    @Override
    public int[][] getWinCombinations() {
        return winCombinations;
    }

    @Override
    public Double takeMoney(Ticket ticket) {
        return money;
    }

    @Override
    public List<Ticket> getLotteryTickets() {
        return tickets;
    }

}