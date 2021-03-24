import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private String e_mail;
    private Education education;



    public static PersonGenerator builder(){
        return new PersonGenerator();
    }

    static class PersonGenerator{

        Person person = new Person();

        public PersonGenerator id (Integer id){
            person.id = id;
            return this;
        }
        public PersonGenerator name(String name){
            person.name = name;
            return this;
        }
        public PersonGenerator e_mail(String e_mail){
            person.e_mail = e_mail;
            return this;
        }
        public PersonGenerator age(Integer age){
            person.age = age;
            return this;
        }
        public PersonGenerator education(Education education){
            person.education = education;
            return this;
        }

        public Person build(){
            return person;
        }
    }

}
