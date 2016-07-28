package impl.lottery;

import api.lottery.Lottery;
import api.lottery.Lottery.Type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nastya on 27.07.2016.
 */
public class Service implements api.lottery.Service {
    Map<Long, Lottery> lotteries = new HashMap<>();
    List<api.lottery.Ticket> winningTickets;
    /**
     * create new lottery with certain type and put it into map.
     * Also this method should create lottery tickets and put them into lottery.
     *
     * @param type - type of lottery
     * @return number of ticket
     */
    @Override
    public Long performNewLottery(Type type) {
        switch (type) {
            case LOTTO:
                winningTickets = LotoLottery.winnigTickets();
                LotoLottery lotoLottery = new LotoLottery();
                for (long i = 0; i < 1000000; i++)
                    lotoLottery.tickets.add(new Ticket(i));
                lotteries.put(lotoLottery.getLotteryNumber(), lotoLottery);
                lotoLottery.performLottery();

                return lotoLottery.getLotteryNumber();
            case INSTANT:
                winningTickets = InstantLottery.winnigTickets();
                InstantLottery instantLottery = new InstantLottery();
                for (long i = 0; i < 1000000; i++)
                    instantLottery.tickets.add(new Ticket(i));
                lotteries.put(instantLottery.getLotteryNumber(), instantLottery);
                instantLottery.performLottery();

                return instantLottery.getLotteryNumber();
        }
        return null;
    }

    @Override
    public List<api.lottery.Ticket> getLotteryTickets(Long lotteryNumber) {

        return lotteries.get(lotteryNumber).getLotteryTickets();
    }

    @Override
    public Double takeMoney(Long lotteryNumber, api.lottery.Ticket ticket) {

        if (winningTickets.contains(ticket)) {
            return lotteries.get(lotteryNumber).takeMoney(ticket);
        } else return null;
    }

    @Override
    public void endLottery(Long lotteryNumber) {
        lotteries.remove(lotteryNumber);

    }


}
