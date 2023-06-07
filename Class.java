import java.util.*;

public class Class {
  private int numGrades;
  private ArrayList<Grade> grades;
  private String className;
  private int classID;
  public static classIDGenerator = 0;
  private gradeIDGenerator = 0;

  public Class(String className) {
    classIDGenerator++;
    this.classID = classIDGenerator;
    this.className = className;
  }

  public void addGrade() {
    Scanner in = new Scanner(System.in);
    System.out.print("What is the value of the grade?: ");
    double numGrade = in.nextDouble();
    System.out.print("What is the type of the grade?: "); // TODO: Error checking
    String typeGrade = in.next();
    System.out.print("What is the name of the grade?: ");
    String nameGrade = in.next();
    Grade gr = new Grade(numGrade, typeGrade, nameGrade);
    this.gradeIDGenerator++;
    gr.setID(this.gradeIDGenerator);
    this.grades.add(gr);
    in.close();
  }

  public void deleteGrade() {
    Scanner in = new Scanner(System.in);
    for (Grade grade : this.grades) {
      System.out.printf("[%d]: %s: %0.2f\n", grade.getID(), grade.getName(),
                        grade.getNumGrade());
    }
    System.out.println("\nEnter the ID of the grade you want to delete: ");
    this.grades.remove(in.nextInt());

    // TODO: delete by index? maybe by name? idk
    //
    in.close();
  }

  public void editGrade() {
    Scanner in = new Scanner(System.in);
    // TODO: edit by index or name
    in.close();
  }

  public double calcNumAverage() {
    double sum = 0;
    for (Grade grade : this.grades) {
      sum += grade.getNumGrade();
    }

    avg = sum / this.grades.size();
    return avg;
  }

  public char calcLetterAverage() {
    double avg = calcNumAverage();
    char letterGrade;
    if (avg < 60) {
      letterGrade = 'F';
    } else if (avg < 70) {
      letterGrade = 'D';
    } else if (avg < 80) {
      letterGrade = 'C';
    } else if (avg < 90) {
      letterGrade = 'B';
    } else {
      letterGrade = 'A';
    }

    return letterGrade;
  }
}
