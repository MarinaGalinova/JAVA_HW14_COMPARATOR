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


    public boolean matches1(Ticket ticket, String from) {
        String s1 = ticket.getFrom();
        return ticket.getFrom().contains(from);
    }

    public boolean matches2(Ticket ticket, String too) {
        String s2 = ticket.getTo();
        return ticket.getTo().contains(too);
    }

    public Ticket[] findAll(String from, String too) {
        int findAllTickets = 0;
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу билеты
        for (Ticket ticket : repo.getTickets()) {
            if (matches1(ticket, from) & matches2(ticket, too)) {
                Ticket[] tmp = new Ticket[result.length + 1]; // временный массив в случае совпадения
                for (int i = 0; i < tmp.length; i++) {
                    if (result.length > 0) {
                        tmp[i] = result[i]; //перекладываем подходящие билеты из старого массива в новый
                    }
                    result = tmp;
                }
                result[findAllTickets] = ticket;
                findAllTickets++;// "добавляем в конец" массива result билет ticket
            }
        }
        TicketComparator ticketComparator = new TicketComparator();
        Arrays.sort(result, ticketComparator);
        return result;
    }


}






