package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Ticket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Nastya on 27.07.2016.
 */
public class InstantLottery implements Lottery {

    private static List<Ticket> winningTickets = new LinkedList<>();
    public Double money = 0d;
    /**
     * Тип - мгновенная
     * - номер лотереи
     * - тип
     * - билеты участвующие в розыгрыше
     * - провести розыгрыш
     * - выиграшные комбинации
     * - забрать выигрыш
     */
    Random rand = new Random();
    List<Ticket> tickets = new ArrayList<>();
    private int[][] winCombinations = new int[5][0];
    private Long lotteryNumber = rand.nextLong();

    public static List<Ticket> winnigTickets() {
        return winningTickets;
    }

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
        getWinCombinations();
        for (int i = 0; i < tickets.size(); i++) {
            for (int j = 0; j < tickets.get(i).getCombination().length; j++) {
                for (int k = 0; k < tickets.get(i).getCombination().length; k++) {
                    for (int l = 0; l < getWinCombinations().length; l++) {
                        if (tickets.get(i).getCombination()[j][k] == getWinCombinations()[l][0]) {
                            money += 5d;
                            winningTickets.add(tickets.get(i));
                            takeMoney(tickets.get(i));
                        }
                    }
                }
            }
        }
    }

    @Override
    public int[][] getWinCombinations() {
        for (int i = 0; i < winCombinations.length; i++) {
            for (int j = 0; j < winCombinations[i].length; j++) {
                winCombinations[i][j] = rand.nextInt(10);
            }
        }
        return winCombinations;
    }

    @Override
    public Double takeMoney(Ticket ticket) {
        return money;
    }
}