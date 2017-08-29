package me.dev1001.examples.idioms.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class EmployeeTaxStrategy implements TaxStrategy<Employee> {

  private static final double NORMAL_RATE = 0.40;
  private static final double MARRIED_FEMALE_RATE = 0.48;

  @Override
  public double extortCash(Employee e) {
    if (e.isMarried() && e.getGender() == Employee.Gender.FEMALE) {
      return e.getIncome() * MARRIED_FEMALE_RATE;
    }
    return e.getIncome() * NORMAL_RATE;
  }
}
