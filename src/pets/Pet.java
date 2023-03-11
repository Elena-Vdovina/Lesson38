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

  /*
    Pet(String kind, String nickname, String dataBirthday){
      setKind(kind);
      this.nickname=nickname;
      this.dataBirthday=dataBirthday;
    }
  */
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
    int firstSepIndex = line.indexOf(SEP);
    int secondSepIndex = line.indexOf(SEP, firstSepIndex + 1);
    int thirdSepIndex = line.indexOf(SEP, secondSepIndex + 1);
    String kind = "other";
    String nickname = "";
    String dataBirthday = "";
    String sweight = "";
    Double weight = -1.0;
    if (firstSepIndex != -1) {
      kind = line.substring(0, firstSepIndex);
      nickname = line.substring(firstSepIndex + 1);
    } else {
      return new Pet(kind,/*nickname*/line);
    }
    if (secondSepIndex != -1) {
      nickname = line.substring(firstSepIndex + 1, secondSepIndex-1);
      sweight = line.substring(secondSepIndex + 1);
    }
    if (thirdSepIndex != -1) {
      sweight = line.substring(secondSepIndex + 1, thirdSepIndex-1);
      dataBirthday = line.substring(thirdSepIndex + 1);
    }
    if (secondSepIndex != -1 || thirdSepIndex != -1) {
      weight = Double.parseDouble(sweight);
    }
    return new Pet(kind, nickname, weight, dataBirthday);
  }

}


