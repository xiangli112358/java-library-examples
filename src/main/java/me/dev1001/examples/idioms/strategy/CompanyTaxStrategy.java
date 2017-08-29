package me.dev1001.examples.idioms.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class CompanyTaxStrategy implements TaxStrategy<Company> {

  private static final double BIG_COMPANY_RATE = 0.30;
  private static final double SMALL_COMPANY_RATE = 0.15;

  public double extortCash(Company company) {
    if (company.getNumberOfEmployees() > 5
        && company.getIncome() < 1000000) {
      return company.getIncome() * SMALL_COMPANY_RATE;
    }
    return company.getIncome() * BIG_COMPANY_RATE;
  }
}
