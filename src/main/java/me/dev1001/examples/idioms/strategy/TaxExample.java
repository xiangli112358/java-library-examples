package me.dev1001.examples.idioms.strategy;

/**
 * Created by hongzong.li on 5/4/17.
 */
public class TaxExample {

  public static void main(String[] args) {
    EmployeeTaxStrategy employeeTaxStrategy = new EmployeeTaxStrategy();
    Employee employee = new Employee(employeeTaxStrategy, 100, false, Employee.Gender.MALE);
    System.out.println(employee.extortCash());

    GovernmentEmployee specialEmployee = new GovernmentEmployee(
        employeeTaxStrategy, 200, true, Employee.Gender.FEMALE);
    System.out.println(specialEmployee.extortCash());

    CompanyTaxStrategy companyTaxStrategy = new CompanyTaxStrategy();
    Company smallCompany = new Company(companyTaxStrategy, 100000, 5);
    System.out.println(smallCompany.extortCash());
  }
}
