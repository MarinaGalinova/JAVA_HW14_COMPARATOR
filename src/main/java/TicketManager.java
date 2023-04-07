import static java.awt.SystemColor.text;
import static java.util.regex.Pattern.matches;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.saveTicket(ticket);
    }


    public boolean matchesFrom(Ticket ticket, String from) {
        String s1 = ticket.getFrom();
        return ticket.getFrom().contains(from);
    }

    public boolean matchesTo(Ticket ticket, String too) {
        String s2 = ticket.getTo();
        return ticket.getTo().contains(too);
    }

    public Ticket[] findAll(String from, String too) {
        int findAllTickets = 0;
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу билеты
        for (Ticket ticket : repo.getTickets()) {
            if (matchesFrom(ticket, from) & matchesTo(ticket, too)) {
                Ticket[] tmp = new Ticket[result.length + 1]; // временный массив в случае совпадения
                for (int i = 0; i < tmp.length-1; i++) {
                    if (result.length > 0) {
                        tmp[i] = result[i]; //перекладываем подходящие билеты из старого массива в новый
                    }
                }
                result = tmp;
                result[findAllTickets] = ticket;
                findAllTickets++;// "добавляем в конец" массива result билет ticket
            }
        }
        if (result.length >= 2) {
            TicketComparator ticketComparator = new TicketComparator();
            //        Arrays.sort(result, ticketComparator);
            Ticket tmpTicket = result[0];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length - i - 1; j++) {
                    if (ticketComparator.compare(result[j], result[j + 1]) == 1) {
                        tmpTicket = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = tmpTicket;
                    }
                }
            }
        }
        return result;
    }


}






