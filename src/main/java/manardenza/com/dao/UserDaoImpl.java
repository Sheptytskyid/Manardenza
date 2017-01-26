package manardenza.com.dao;

public class UserDaoImpl<T> extends AbstractDao {

    private static UserDaoImpl instance;

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }
}
