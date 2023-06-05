public class Grade {

  private double numGrade;
  private char letterGrade;
  private String gradeType;
  private String gradeName;

  public Grade(double grade, String type, String name) {
    numGrade = grade;
    gradeType = type;
    gradeName = name;
  }

  public double getGrade() {return numGrade;}

  public char getLetterGrade() {
    if (numGrade < 60) {
      letterGrade = 'F';
    } else if (numGrade < 70) {
      letterGrade = 'D';
    } else if (numGrade < 80) {
      letterGrade = 'C';
    } else if (numGrade < 90) {
      letterGrade = 'B';
    } else if (numGrade <= 100) {
      letterGrade = 'A';
    } else {
      letterGrade = 'A';
    }

    return letterGrade;
  }

  public String getType() {return gradeType};

  public String getName() {return gradeName};

  public void setGrade(double newGrade) {numGrade = newGrade;}

  public void setType(String newType) {gradeType = newType;}

  public void setName(String newName) {gradeName = newName;}

}
