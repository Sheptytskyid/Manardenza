package manardenza.com.login;

import manardenza.com.entity.User;
import lombok.Data;

@Data
public class CurrentUser {

    private static CurrentUser loggedUser;
    private User user;

    public static CurrentUser getInstance() {
        if (loggedUser == null) {
            loggedUser = new CurrentUser();
        }
        return loggedUser;
    }
}
