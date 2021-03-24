import lombok.Data;
import lombok.ToString;

import javax.swing.text.html.parser.TagElement;

@Data
@ToString
public class User {
    private int id;
    private String name;
    private int age;
    private Education education;

    public UserGen builder(){
        return new UserGen();
    }

    public class UserGen{

        User user = new User();

    public UserGen id(Integer id){
        user.id = id;
        return this;
    }
    public UserGen name(String name){
        user.name = name;
        return this;
    }
    public UserGen age(Integer age){
        user.age = age;
        return this;
    }
    public UserGen education(Education education){
        user.education = education;
        return this;
    }
    public User build(){
        return user;
    }

    }
}
