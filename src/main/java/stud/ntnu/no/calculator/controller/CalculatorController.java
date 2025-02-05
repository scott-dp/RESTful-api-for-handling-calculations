package stud.ntnu.no.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import stud.ntnu.no.calculator.model.Calculation;

@org.springframework.web.bind.annotation.RestController
public class CalculatorController {
  @PostMapping("/calculate")
  public ResponseEntity<Double> calculateResult(@RequestBody Calculation calculation) {
    double result;
    try {
      result = calculation.calculate();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(result);
  }
}
