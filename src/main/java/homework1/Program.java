package homework1;

import com.google.gson.Gson;

public class Program {

    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 30);

        Gson gson = new Gson();

        // Сериализация объекта в формат JSON
        String json = gson.toJson(person);
        System.out.println(json);

        // Десериализация объекта из формата JSON
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println(deserializedPerson);
    }
}
