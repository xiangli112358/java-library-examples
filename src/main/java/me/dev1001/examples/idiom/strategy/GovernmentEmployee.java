package me.dev1001.examples.idiom.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class GovernmentEmployee extends Employee {

  public GovernmentEmployee(
      TaxStrategy<Employee> strategy, double income, boolean married,
      Gender gender) {
    super(strategy, income, married, gender);
  }
}
