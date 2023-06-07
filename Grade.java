public class Grade {

  private double numGrade;
  private char letterGrade;
  private String gradeType;
  private String gradeName;
  private int gradeID;

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

  public double getNumGrade() {return this.numGrade};

  public char getLetterGrade() {return this.letterGrade};

  public String getType() {return this.gradeType};

  public String getName() {return this.gradeName};

  public int getID() {return this.gradeID};

  public void setGrade(double newGrade) {this.numGrade = newGrade;}

  public void setType(String newType) {this.gradeType = newType;}

  public void setName(String newName) {this.gradeName = newName;}

  public void setID(double newID) {this.gradeID = newID};

}
