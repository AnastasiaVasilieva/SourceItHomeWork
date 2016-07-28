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
     * - билеты участвующие в розыгрыше
     * - провести розыгрыш
     * - выиграшные комбинации
     * - забрать выигрыш
     */
    List<Ticket> tickets = new ArrayList<>();
    static List<Ticket> winningTickets = new ArrayList<>();
    Random rand = new Random();
    private Long lotteryNumber = rand.nextLong();
    private int[][] winCombinations = getWinCombinations();


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
        for (int i = 0; i < tickets.size(); i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < getWinCombinations().length; k++) {
                    if (tickets.get(i).getCombination()[j][0] == getWinCombinations()[k][0] &&
                            tickets.get(i).getCombination()[j][1] == getWinCombinations()[k][1] &&
                            tickets.get(i).getCombination()[j][2] == getWinCombinations()[k][2] &&
                            tickets.get(i).getCombination()[j][3] == getWinCombinations()[k][3]) {
                        count++;
                        winningTickets.add(tickets.get(i));
                    }
                }
            }
            switch (count) {
                case 1: {
                    money = 100d;
                    takeMoney(tickets.get(i));
                }
                break;
                case 2: {
                    money = 500d;
                    takeMoney(tickets.get(i));
                }
                break;
                case 3: {
                    money = 1000d;
                    takeMoney(tickets.get(i));
                }
                break;

            }
        }

    }

    @Override
    public int[][] getWinCombinations() {
        winCombinations = new int[4][4];
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

    public static List<Ticket> winnigTickets() {
        return winningTickets;
    }
}