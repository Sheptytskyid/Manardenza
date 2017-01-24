package entities;

public class Room {

    private long id;
    private int person;
    private int price;
    private User orderedUser;

    public Room(long id, int person, int price, User orderedUser) {
        this.id = id;
        this.person = person;
        this.price = price;
        this.orderedUser = orderedUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getOrderedUser() {
        return orderedUser;
    }

    public void setOrderedUser(User orderedUser) {
        this.orderedUser = orderedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (person != room.person) return false;
        if (price != room.price) return false;
        return orderedUser != null ? orderedUser.equals(room.orderedUser) : room.orderedUser == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + person;
        result = 31 * result + price;
        result = 31 * result + (orderedUser != null ? orderedUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{"
                + "id=" + id
                + ", person=" + person
                + ", price=" + price
                + ", orderedUser=" + orderedUser
                + '}';
    }
}
