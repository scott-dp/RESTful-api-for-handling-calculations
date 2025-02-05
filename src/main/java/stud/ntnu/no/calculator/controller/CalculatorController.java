package stud.ntnu.no.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import stud.ntnu.no.calculator.model.Calculation;
import stud.ntnu.no.calculator.model.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@org.springframework.web.bind.annotation.RestController
public class CalculatorController {
  private static final Logger logger = LogManager.getLogger(CalculatorController.class);
  @CrossOrigin(origins = "http://localhost:5173")
  @PostMapping("/calculate")
  public ResponseEntity<Result> calculateResult(@RequestBody Calculation calculation) {
    logger.info("Requested calculation: " + calculation.getCalculation());
    Result result;
    try {
      result = calculation.calculate();
      logger.info("calculation successful, result: " + result.getResult());
    } catch (Exception e) {
      logger.error("Error: " + e.getMessage());
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(result);
  }
}
