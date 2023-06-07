public class GradeCategory {
  private String categoryName;
  private double weight;

  public GradeCategory(String name, double weight) {
    this.categoryName = name;
    this.weight = weight;
  }
  
  @Override
  public String toString() { return this.categoryName; }
  
  public String getCategoryName() { return this.categoryName; }

  public double getWeight() { return this.weight ; }

  public void setTypeName(String newName) { this.categoryName = newName; }

  public void setWeight(double newWeight) { this.weight = newWeight; }

}
