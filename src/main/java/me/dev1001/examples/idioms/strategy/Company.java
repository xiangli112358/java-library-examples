package me.dev1001.examples.idioms.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class Company extends TaxPayer<Company> {

  public Company(TaxStrategy<Company> strategy, double income, int numberOfEmployees) {
    super(strategy, income);
    this.numberOfEmployees = numberOfEmployees;
  }

  private int numberOfEmployees;

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  @Override
  protected Company getType() {
    return this;
  }
}
