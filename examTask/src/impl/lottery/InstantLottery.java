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
     * Тип - мгновенная
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
        return Type.INSTANT;
    }

    @Override
    public void performLottery() {
        getWinCombinations();
        for (Ticket ticket : tickets) {
            if (ticket.getCombination()[0][0] == getWinCombinations()[0][0] &&
                    ticket.getCombination()[1][1] == getWinCombinations()[1][1] &&
                    ticket.getCombination()[2][2] == getWinCombinations()[2][2] &&
                    ticket.getCombination()[3][3] == getWinCombinations()[3][3]) {
                money = 100d;
                takeMoney(ticket);
                winningTickets.add(ticket);
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