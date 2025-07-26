import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
        Gson gson = new Gson();
        String json = gson.toJson(p);
        System.out.println("JSON: " + json);
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
