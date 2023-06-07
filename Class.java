import java.util.*;

public class Class {
  private int numGrades;
  private ArrayList<Grade> grades;
  private String className;
  private int classID;
  private ArrayList<GradeCategory> categories;
  public static int classIDGenerator = 0;
  private int gradeIDGenerator = 0;

  public Class(String className) {
    classIDGenerator++;
    this.classID = classIDGenerator;
    this.className = className;
    this.categories = new ArrayList<GradeCategory>();
    this.grades = new ArrayList<Grade>();
  }

  public void addGrade(Scanner in) {
    boolean invalid = true;
    double numGrade;
    GradeCategory gradeCategory = null;
    String nameGrade = null;
    
    do { // have to revamp this because break dunna work in if statements
      System.out.print("Enter the value of the grade.\n> ");
      numGrade = in.nextDouble();
      if (numGrade < 0 || numGrade > 100) {
        System.out.println("Invalid grade value.");
      }
      System.out.printf("|%-6s|%-14s|%-7s|%n","Index", "Category Name", "Weight");
      printSeperator(30);
      int index=0;
      for (GradeCategory category : this.categories) {
        index++;
        System.out.printf("|%-6d|%-14s|%-7.2f|%n", index, category.getCategoryName(), category.getWeight());
        printSeperator(30);
      }
      System.out.print("\nEnter the index of the category you'd like to add the grade to.\n> ");
      int indexCategory = in.nextInt();      
      if (indexCategory < 0 || indexCategory > categories.size()) {
        System.out.println("Invalid grade category index.");
        break;
      }
      gradeCategory = this.categories.get(indexCategory-1);
      System.out.print("Enter the name of the grade.\n> ");
      nameGrade = in.nextLine();
      invalid = false;
    } while (invalid == true);

    Grade gr = new Grade(numGrade, gradeCategory, nameGrade);
    this.gradeIDGenerator++;
    gr.setID(this.gradeIDGenerator);
    this.grades.add(gr);
  }

  public void deleteGrade(Scanner in) {
    boolean invalidID;
    ArrayList<Integer> IDs = new ArrayList<Integer>();
    do {
      System.out.printf("|%-10s|%-20s|%-13s|%n", "Grade ID","Grade Name", "Grade Value");
      printSeperator(47);
      for (int i = 0; i < this.grades.size(); i++) {
        System.out.printf("|%-10d|%-20s|%-13.2f|%n", this.grades.get(i).getID(), this.grades.get(i).getName(), this.grades.get(i).getNumGrade());
        printSeperator(47);
        IDs.add(this.grades.get(i).getID());
      }
      System.out.print("\nEnter the ID of the grade you want to delete.\n> ");
      int gradeID = in.nextInt();
      if (grades.indexOf(gradeID) == -1) {
        System.out.println("Invalid grade ID.");
        invalidID = true;
        break;
      }
      this.grades.remove(IDs.indexOf(gradeID));
      invalidID = false;
    } while (invalidID == true);
  }

  public void editGrade(Scanner in) {
    boolean invalidID;
    Grade grade = null;
    ArrayList<Integer> IDs = new ArrayList<Integer>();
    do {
      System.out.printf("|%-10s|%-20s|%-13s|%n", "Grade ID","Grade Name", "Grade Value");
      printSeperator(47);
      for (int i = 0; i < this.grades.size(); i++) {
        System.out.printf("|%-10d|%-20s|%-13.2f|%n", this.grades.get(i).getID(), this.grades.get(i).getName(), this.grades.get(i).getNumGrade());
        printSeperator(47);
        IDs.add(this.grades.get(i).getID());
      }
      System.out.print("\nEnter the ID of the grade you want to edit.\n> ");
      int gradeID = in.nextInt();
      if (grades.indexOf(gradeID) == -1) {
        System.out.println("Invalid grade ID.");
        invalidID = true;
        break;
      }
      grade = this.grades.get(IDs.indexOf(gradeID));
      invalidID = false;
    } while (invalidID == true);
    
    int menuChoice = 0;
 
    do {
      System.out.println("Enter menu choice:");
      System.out.print("[1] Edit Name\n[2] Edit Value\n[3] Edit Category\n[0] Exit\n> ");
      menuChoice = in.nextInt();

      switch (menuChoice) {
        case 1:
          System.out.print("Enter the new name for the grade.\n> ");
          grade.setName(in.next());
          break;

        case 2:
          System.out.print("Enter the new value for the grade. \n> ");
          grade.setGrade(in.nextDouble());
          break;

        case 3:
          System.out.printf("|%-6s|%-13s|%-7s|%n","Index", "Category Name", "Weight");
          printSeperator(30);
          int index=0;
          for (GradeCategory category : this.categories) {
            index++;
            System.out.printf("|%-6d|%-13s|%-7.2f|%n", index, category.getCategoryName(), category.getWeight());
            printSeperator(30);
          }
          System.out.print("\nEnter the index of the category you'd like to switch to.\n> ");
          int catIndex = in.nextInt() - 1;
          grade.setCategory(categories.get(catIndex)); 
          break;

        case 0:
          System.out.println("\nExiting...");
          break;

        default:
          System.out.println("Invalid choice.");
          break;
      }
    } while (menuChoice != 0);
  }

  public void addGradeCategory(Scanner in) {
    System.out.print("What is the name of the grade category?\n> ");
    String categoryName = in.nextLine();

    System.out.print("What is the weight of the grade category\n> ");
    double weight = in.nextDouble();
    GradeCategory gc = new GradeCategory(categoryName, weight);
    this.categories.add(gc);
  }

  public double calcNumAverage() {
    double sum = 0;
    for (Grade grade : this.grades) {
      sum += grade.getNumGrade();
    }

    double avg = sum / this.grades.size();
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

  public void printSeperator(int length) {
    for (int i=0; i < length; i++) {
      System.out.print("-");
    }
    System.out.printf("%n");
  }

  public static void main(String[] args) {
    Class kass = new Class("Test");
    Scanner in = new Scanner(System.in);
    kass.addGradeCategory(in);
    kass.addGrade(in);

    in.close();
  }
}
