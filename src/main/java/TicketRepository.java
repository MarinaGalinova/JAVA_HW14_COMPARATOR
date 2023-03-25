public class TicketRepository {
    public Ticket[] tickets = new Ticket[0];


    public void saveTicket(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;

    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void deleteTicketByID(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];

        int copyToIndex = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;

            }
        }
        tickets = tmp;


    }
}
