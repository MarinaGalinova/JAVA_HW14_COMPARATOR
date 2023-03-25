public class Ticket implements Comparable<Ticket> {
    int id;
    int price;
    String from; //аэропорт вылета
    String too; //аэропорт прилета
    int durationOfFlight;

    public Ticket(int id, int price, String from, String too, int durationOfFlight) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.too = too;
        this.durationOfFlight = durationOfFlight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDepartAirport(String from) {
        this.from = from;
    }

    public void setDestinationAirport(String too) {
        this.too = too;
    }

    public void setDurationOfFlight(int durationOfFlight) {
        this.durationOfFlight = durationOfFlight;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return too;
    }

    public int getDurationOfFlight() {
        return durationOfFlight;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else {
            if (this.price > o.price) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
