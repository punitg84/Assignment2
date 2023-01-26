package studentdirectory.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static studentdirectory.validation.InputValidator.validateSortOption;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.validation.inputvalidatortestscenario.ValidateSortOptionTestScenario;

class InputValidatorTest {
  private static Stream<ValidateSortOptionTestScenario> generateTestCaseForValidateSortOption() {
    //Test Case 1 valid option
    ValidateSortOptionTestScenario testCase1 = new ValidateSortOptionTestScenario();
    testCase1.setInputString("1");
    testCase1.setErrMessage("");
    testCase1.setTestCaseName("Valid option");

    //Test Case 2 invalid option
    ValidateSortOptionTestScenario testCase2 = new ValidateSortOptionTestScenario();
    testCase2.setInputString("9");
    testCase2.setErrMessage("Option needs to lie between 1-8");
    testCase2.setTestCaseName("Invalid option");

    //Test Case 3 non-numeric option
    ValidateSortOptionTestScenario testCase3 = new ValidateSortOptionTestScenario();
    testCase3.setInputString(" ");
    testCase3.setErrMessage("Option needs to have a numeric value");
    testCase3.setTestCaseName("Non numeric option");

    return Stream.of(testCase1, testCase2, testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestCaseForValidateSortOption")
  void testValidateSortOption(ValidateSortOptionTestScenario testCase) {
    String inputString = testCase.getInputString();
    String errMessage = testCase.getErrMessage();
    try{
      validateSortOption(inputString);
      assertEquals(errMessage,"",testCase.getTestCaseName());
    } catch (Exception e) {
      assertEquals(errMessage,e.getMessage(),testCase.getTestCaseName());
    }
  }
}