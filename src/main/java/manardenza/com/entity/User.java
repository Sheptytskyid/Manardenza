package manardenza.com.entity;

import lombok.Data;

@Data
public class User extends AbstractObject {

    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
