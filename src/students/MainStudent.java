package students;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainStudent {

  // написать базу данных студентов
  // студенты могут находиться в группах

  // красиво вывести состав групп на экран
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Student> students = new ArrayList<>();
    // прочитать количество групп
    int groups = Integer.parseInt(br.readLine());
    for (int groupId = 0; groupId < groups; ++groupId) {
      // для каждой группы:
      readGroup(br, students);
    }
    for (Student student : students) {
      System.out.printf("%s (%s) в группе %s%n", student.getName(), student.getEMail(),
          student.getGroup());
    }
  }

  // - прочитать название группы
  // - прочитать количество студентов
  // - прочитать информацию о студентах - "имя" или "имя,e-mail" для каждого в отдельной строке
  private static void readGroup(BufferedReader br, List<Student> students) throws IOException {
    String groupName = br.readLine();
    int studentsNumber = Integer.parseInt(br.readLine());
    BufferedReader fr = new BufferedReader(new FileReader("res/input.txt"));
    FileWriter fw = new FileWriter("res/allstudents", true);
    for (int i = 0; i < studentsNumber; ++i) {
      String line = fr.readLine();
      Student student = Student.parseStudent(groupName, line);
      students.add(student);
      fw.write(student.getName() + "," + student.getEMail() + "," + student.getGroup() + "\n");
    }
    fw.close();
    fr.close();
  }
}
