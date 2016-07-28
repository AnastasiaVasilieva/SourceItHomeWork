package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Service;
import api.lottery.Ticket;

import java.util.List;

/**
 * Created by denis.selutin on 27.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        Service service = new impl.lottery.Service();

        Long lotteryNumber = service.performNewLottery(Lottery.Type.INSTANT);
        List<Ticket> tickets = service.getLotteryTickets(lotteryNumber);
        assert tickets.size() > 0;
        assert service.takeMoney(-1L, tickets.get(0)) == null;
        int numberOfWins = 0;
        for (Ticket t : tickets) {
            if (service.takeMoney(lotteryNumber, t) != null) {
                numberOfWins++;
                System.out.println("Lottery" + " [ticket№" + t.getNumber()
                        + ", money " + service.takeMoney(lotteryNumber, t) + "]");
            }
        }
        assert numberOfWins > 0;
        service.endLottery(lotteryNumber);
        assert service.takeMoney(lotteryNumber, tickets.get(0)) == null;
    }
}
