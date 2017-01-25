package login;

import entities.User;
import lombok.Data;

@Data
public class CurrentUser {

    private User user;
    private static CurrentUser loggedUser = new CurrentUser();
}
