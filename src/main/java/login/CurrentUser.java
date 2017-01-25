package login;

import entities.User;
import lombok.Data;

@Data
public class CurrentUser {

    public static User currentUser;
}
