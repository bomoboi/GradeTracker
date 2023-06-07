public class Grade {

  private double numGrade;
  private char letterGrade;
  private GradeCategory gradeCategory;
  private String gradeName;
  private int gradeID;

  public Grade(double grade, GradeCategory category, String name) {
    this.numGrade = grade;
    this.gradeCategory = category;
    this.gradeName = name;
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

  public double getNumGrade() {return this.numGrade;}

  public String getCategory() {return this.gradeCategory.toString();}

  public String getName() {return this.gradeName;}

  public int getID() {return this.gradeID;}

  public void setGrade(double newGrade) {this.numGrade = newGrade;}

  public void setCategory(GradeCategory newCategory) {this.gradeCategory = newCategory;}

  public void setName(String newName) {this.gradeName = newName;}

  public void setID(int newID) {this.gradeID = newID;}

}
