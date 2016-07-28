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

    /**
     * Тип - лото
     * - номер лотереи
     * - тип
     * - билеты участвующие в розыгрыше
     * - провести розыгрыш
     * - выиграшные комбинации
     * - забрать выигрыш
     */
    static List<Ticket> winningTickets = new ArrayList<>();
    public Double money;
    List<Ticket> tickets = new ArrayList<>();
    Random rand = new Random();
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
        return Type.LOTTO;
    }

    @Override
    public void performLottery() {
        getWinCombinations();
        for (Ticket ticket : tickets) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < getWinCombinations().length; k++) {
                    if (ticket.getCombination()[j][0] == getWinCombinations()[k][0] &&
                            ticket.getCombination()[j][1] == getWinCombinations()[k][1] &&
                            ticket.getCombination()[j][2] == getWinCombinations()[k][2] &&
                            ticket.getCombination()[j][3] == getWinCombinations()[k][3]) {
                        money = 1000d;
                        takeMoney(ticket);
                        winningTickets.add(ticket);
                    }
                }
            }
        }
    }

    @Override
    public int[][] getWinCombinations() {
        int[][] winCombinations = new int[4][4];
        for (int i = 0; i < winCombinations.length; i++) {
            for (int j = 0; j < winCombinations[i].length; j++) {
                winCombinations[i][j] = rand.nextInt(40);
            }
        }
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