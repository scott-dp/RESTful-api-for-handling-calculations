package stud.ntnu.no.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import stud.ntnu.no.calculator.model.Calculation;
import stud.ntnu.no.calculator.model.Result;

@org.springframework.web.bind.annotation.RestController
public class CalculatorController {
  @CrossOrigin(origins = "http://localhost:5173")
  @PostMapping("/calculate")
  public ResponseEntity<Result> calculateResult(@RequestBody Calculation calculation) {
    System.out.println(calculation.getCalculation());//TODO Replace with logger
    Result result;
    try {
      result = calculation.calculate();
      System.out.println(result);//TODO replace with logger
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(result);
  }
}
