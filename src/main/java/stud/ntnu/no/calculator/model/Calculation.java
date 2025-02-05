package stud.ntnu.no.calculator.model;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculation {
  private String calculation;
  public String getCalculation() {
    return calculation;
  }

  public void setCalculation(String calculation) {
    this.calculation = calculation;
  }

  public double calculate() {
    Expression expression = new ExpressionBuilder(calculation).build();
    return expression.evaluate();
  }
}
