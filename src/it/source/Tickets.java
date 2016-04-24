package it.source;

public class Tickets {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Tickets tickets = new Tickets();

        System.out.println(tickets.kolTickets(array.length));
    }

    public int kolTickets(int length) {
        int sum = 0;
        for (int i = 000001; i <= length; i++) {
            int number1 = i / 100000;
            int number2 = (i / 10000) % 10;
            int number3 = (i / 1000) % 10 % 10;
            int number4 = (i / 100) % 10 % 10 % 10;
            int number5 = (i / 10) % 10 % 10 % 10 % 10;
            int number6 = i % 10 % 10 % 10 % 10;

            if (number1 + number2 + number3 == number4 + number5 + number6) {
                sum++;
            }
        }
        return sum;
    }
}