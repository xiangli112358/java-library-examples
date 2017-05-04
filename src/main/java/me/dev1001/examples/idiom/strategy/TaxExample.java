package me.dev1001.examples.idiom.strategy;

import me.dev1001.examples.idiom.strategy.Employee.Gender;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class TaxExample {

  public static void main(String[] args) {
    EmployeeTaxStrategy employeeTaxStrategy = new EmployeeTaxStrategy();
    Employee employee = new Employee(employeeTaxStrategy, 100, false, Gender.MALE);
    System.out.println(employee.extortCash());

    GovernmentEmployee specialEmployee = new GovernmentEmployee(
        employeeTaxStrategy, 200, true, Gender.FEMALE);
    System.out.println(specialEmployee.extortCash());

    CompanyTaxStrategy companyTaxStrategy = new CompanyTaxStrategy();
    Company smallCompany = new Company(companyTaxStrategy, 100000, 5);
    System.out.println(smallCompany.extortCash());
  }
}
