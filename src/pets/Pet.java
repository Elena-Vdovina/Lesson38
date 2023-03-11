package pets;

public class Pet {
  private enum Kind {
    DOG,
    CAT,
    OTHER
  }

  private Pet.Kind kind;
  private String nickname;
  private String dataBirthday;
  private Double weight;

  Pet(String kind, String nickname) {
    setKind(kind);
    this.nickname = nickname;
  }

  Pet(String kind, String nickname, Double weight) {
    setKind(kind);
    this.nickname = nickname;
    this.weight = weight;
  }

  Pet(String kind, String nickname, String dataBirthday, Double weight) {
    setKind(kind);
    this.nickname = nickname;
    this.dataBirthday = dataBirthday;
    this.weight = weight;
  }

  private void setKind(String kind) {
    if (kind.equalsIgnoreCase("dog")) {
      this.kind = Kind.DOG;
    } else if (kind.equalsIgnoreCase("cat")) {
      this.kind = Kind.CAT;
    } else {
      this.kind = Kind.OTHER;
    }
  }

}


