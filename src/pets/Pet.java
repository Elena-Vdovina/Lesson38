package pets;

public class Pet {
  private enum Kind{
    DOG,
    CAT,
    OTHER
  }

  private Pet.Kind kind;
  private String nickname;
  private String dataBirthday;
  private Double weight;

}
