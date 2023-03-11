package pets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

// Создать класс Pet (домашнее животное). В классе должны быть:
//    enum Kind для вида животного (DOG, CAT, OTHER);
//    поля:
//        "вид животного" (тип Kind),
//        "кличка" (тип String),
//        "дата рождения" (тип String),
//        вес (тип double);
//    конструктор, сеттеры, геттеры;
//    статический метод для создания животного при прочтении данных из строки "dog,кличка",
//    "cat,кличка,вес", "turtle,кличка,вес,дата рождения".
// Создать класс Main, в котором данные будут считываться с консоли и красиво выводиться на экран.
// Формат входных данных: количество строк с записями о домашних животных,
// затем сами записи в описанном формате.

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Pet> pets = new ArrayList<>(n);
    for (int i = 0; i < n; ++i) {
      String line = br.readLine();
      Pet pet = Pet.parsePet(line);
      pets.add(pet);
    }
    for (Pet pet : pets) {
          System.out.printf("%-6s %-10s %8.3f %s\n", pet.getKind(), pet.getNickname(), pet.getWeight(),
          pet.getDataBirthday());
    }
  }
}

