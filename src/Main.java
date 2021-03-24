import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {

        Person roman = Person.builder().id(1).name("Roman").e_mail("Hlodan").age(24).education(Education.higt).build();
        System.out.println(roman);


//1 Дістати з файлу Person.txt всіх користувачів
//2 Зробити все необхідно, щоб :
// - відсортувати користувачів за id
// - відсортувати користувачів за імейлом
// - відфільтрувати користувачів , залишивши тільки тих хто має гугловський аккаунт.
//3. Зробити ці всі дії
//ФАЙЛ НЕ ЗМІНЮВАТИ!


        File file = new File("C:" + File.separator + "Users" + File.separator + "stigm" + File.separator + "Desktop" + File.separator + "Person.txt");
        FileInputStream stream = new FileInputStream(file);
        int size = stream.available();
        byte[] bytes = new byte[size];
        stream.read(bytes);
//        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes);
        String[] split = s.split("\n");
        ArrayList<Person> people = new ArrayList<>();
        for (String person : split) {
            person = person.replace("\r", "");
            String[] personProps = person.split(" ");
//            System.out.println(Arrays.toString(personProps));
            Person pers = new Person(Integer.parseInt(personProps[0]), personProps[1], Integer.parseInt(personProps[2]), personProps[3], Education.valueOf(personProps[4]));
            people.add(pers);
        }
        for (Person person : people) {
            System.out.println(person);
        }
//
        Comparator<Person> personComparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId()-o2.getId();
            }
        };
        people.sort(personComparator);
//        System.out.println(people);

        Comparator<Person> objectComparator = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getE_mail().compareTo(o2.getE_mail());
            }
        };
        people.sort(objectComparator);
//        System.out.println(people);

        for (Person person : people) {
            if (person.getE_mail().endsWith("@gmail.com")){
                System.out.println(person);
            }
        }

        Comparator<Person> personComparator1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        people.sort(personComparator1);
        System.out.println(people);


    }
}

