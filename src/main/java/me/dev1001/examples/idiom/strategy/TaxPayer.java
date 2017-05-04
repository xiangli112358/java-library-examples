package me.dev1001.examples.idiom.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public abstract class TaxPayer<P extends TaxPayer<P>> {

  private double income;
  private TaxStrategy<P> strategy;

  public TaxPayer(TaxStrategy<P> strategy, double income) {
    this.strategy = strategy;
    this.income = income;
  }

  public double getIncome() {
    return income;
  }

  protected abstract P getType();


  public double extortCash() {
    return strategy.extortCash(getType());
  }
}
