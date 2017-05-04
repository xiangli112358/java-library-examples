package me.dev1001.examples.idiom.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class Employee extends TaxPayer<Employee> {

  public enum Gender {MALE, FEMALE}

  private final boolean married;
  private final Gender gender;

  public Employee(TaxStrategy<Employee> strategy, double income,
      boolean married, Gender gender) {
    super(strategy, income);
    this.married = married;
    this.gender = gender;
  }

  @Override
  protected Employee getType() {
    return this;
  }

  public boolean isMarried() {
    return married;
  }

  public Gender getGender() {
    return gender;
  }
}
