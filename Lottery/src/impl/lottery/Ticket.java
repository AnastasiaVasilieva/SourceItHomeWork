package impl.lottery;

import java.util.Random;

public class Ticket implements api.lottery.Ticket {
    /*
     - серийный номер
    - комбинации [][]
    - скрытое значение
     */
    Random random = new Random();
    private Long number;
    private Integer ticketValue = random.nextInt(1000);

    Ticket(Long number) {
        this.number = number;
    }

    @Override
    public Long getNumber() {
        return number;
    }

    @Override
    public int[][] getCombination() {
        int[][] combination = new int[4][4];
        for (int i = 0; i < combination.length; i++) {
            for (int j = 0; j < combination[i].length; j++) {
                combination[i][j] = random.nextInt(40);
            }
        }
        return combination;
    }

    @Override
    public Integer getTicketValue() {
        return ticketValue;
    }

}