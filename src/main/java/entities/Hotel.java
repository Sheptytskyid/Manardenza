package entities;

class Hotel extends Room {

    private long id;
    private String name;
    private String city;

    public Hotel(long id, int person, int price, User orderedUser, long id1, String name, String city) {
        super(id, person, price, orderedUser);
        this.id = id1;
        this.name = name;
        this.city = city;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
