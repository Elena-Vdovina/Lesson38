package pets;

import students.Student;

public class Pet {

  final private static char SEP = ',';

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

  Pet(String kind, String nickname, Double weight, String dataBirthday) {
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

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public void setDataBirthday(String dataBirthday) {
    this.dataBirthday = dataBirthday;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Kind getKind() {
    return kind;
  }

  public String getNickname() {
    return nickname;
  }

  public String getDataBirthday() {
    return dataBirthday;
  }

  public Double getWeight() {
    return weight;
  }

  public static Pet parsePet(String line) {
    int firstSepIndex = -1;
    int secondSepIndex = -1;
    int thirdSepIndex = -1;
    String kind = "other";
    String nickname = "";
    String dataBirthday = "";
    String sweight = "";
    double weight = 0.0;
    firstSepIndex = line.indexOf(SEP);
    if (firstSepIndex != -1) {
      secondSepIndex = line.indexOf(SEP, firstSepIndex + 1);
      kind = line.substring(0, firstSepIndex);
      nickname = line.substring(firstSepIndex + 1);
    } else {
      return new Pet(kind,/*nickname*/line, weight, dataBirthday);
    }
    if (secondSepIndex != -1) {
      thirdSepIndex = line.indexOf(SEP, secondSepIndex + 1);
      nickname = line.substring(firstSepIndex + 1, secondSepIndex);
      sweight = line.substring(secondSepIndex + 1);
    }
    if (thirdSepIndex != -1) {
      sweight = line.substring(secondSepIndex + 1, thirdSepIndex);
      dataBirthday = line.substring(thirdSepIndex + 1);
    }
    if (secondSepIndex != -1 || thirdSepIndex != -1) {
      weight = Double.parseDouble(sweight);
    }
    return new Pet(kind, nickname, weight, dataBirthday);
  }

}

