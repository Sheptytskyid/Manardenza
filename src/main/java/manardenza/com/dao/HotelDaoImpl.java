package manardenza.com.dao;

public class HotelDaoImpl<T> extends AbstractDao {

    private static HotelDaoImpl instance;

    public static HotelDaoImpl getInstance() {
        if (instance == null) {
            instance = new HotelDaoImpl();
        }
        return instance;
    }
}
