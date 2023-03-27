import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestTicket {

    Ticket ticket1 = new Ticket(1, 1000, "PRM", "AYT", 6);
    Ticket ticket2 = new Ticket(2, 2000, "VKO", "LIS", 4);
    Ticket ticket3 = new Ticket(3, 3000, "VKO", "LIS", 5);
    Ticket ticket4 = new Ticket(4, 500, "PRM", "AYT", 4);
    Ticket ticket5 = new Ticket(5, 500, "PRM", "AYT", 4);
    Ticket ticket6 = new Ticket(6, 1500, "PRM", "LIS", 7);
    @Test
    public void createRepository() {
        TicketRepository repo = new TicketRepository();
        repo.saveTicket(ticket1);
        repo.saveTicket(ticket2);
        repo.saveTicket(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void delByID() {
        TicketRepository repo = new TicketRepository();
        repo.saveTicket(ticket1);
        repo.saveTicket(ticket2);
        repo.saveTicket(ticket3);
        repo.deleteTicketByID(ticket2.getId());

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        String from = "VKO";
        String too = "LIS";

        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findAllPrice2low() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket4);

        String from = "PRM";
        String too = "AYT";

        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findAllPriceEqual() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket5);
        manager.add(ticket4);

        String from = "PRM";
        String too = "AYT";

        Ticket[] expected = {ticket5, ticket4};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findNoOne() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket4);

        String from = "PRM";
        String too = "LIS";

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findOne() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        String from = "PRM";
        String too = "LIS";

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findThree() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        String from = "PRM";
        String too = "AYT";

        Ticket[] expected = {ticket4, ticket5, ticket1};
        Ticket[] actual = manager.findAll(from, too);

        Assertions.assertArrayEquals(expected, actual);
    }

    //тесты на метод поиска когда
    // 1) находится несколько билетов;
    // 2) находится ровно один билет; 3) находится 0 билетов, т.е. ни один билет не подходит.
//    @Test
//    public void searchByTextOneword2Result() {
//        TicketRepository repo = new TicketRepository();
//        ProductManager manager = new ProductManager(repo);
//        manager.add(ticket1);
//        manager.add(ticket2);
//        manager.add(ticket3);
//        String text = "мух";
//
//        Ticket[] expected = {ticket1, ticket2};
//        Ticket[] actual = manager.searchBy(text);
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void searchByTextOneword0Result() {
//        TicketRepository repo = new TicketRepository();
//        ProductManager manager = new ProductManager(repo);
//        manager.add(ticket1);
//        manager.add(ticket2);
//        manager.add(ticket3);
//        String text = "Оляпка";
//
//        Ticket[] expected = {};
//        Ticket[] actual = manager.searchBy(text);
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void searchByHoleText() {
//        TicketRepository repo = new TicketRepository();
//        ProductManager manager = new ProductManager(repo);
//        manager.add(ticket1);
//        manager.add(ticket2);
//        manager.add(ticket3);
//        String text = "Повелитель мух";
//
//        Ticket[] expected = {ticket1};
//        Ticket[] actual = manager.searchBy(text);
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
}



