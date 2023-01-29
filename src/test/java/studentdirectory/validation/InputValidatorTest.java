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
    ValidateSortOptionTestScenario testCase1 = ValidateSortOptionTestScenario.builder()
                                              .inputString("1")
                                              .errMessage("")
                                              .testCaseName("Valid Option")
                                              .build();

    //Test Case 2 invalid option
    ValidateSortOptionTestScenario testCase2 = ValidateSortOptionTestScenario.builder()
                                              .inputString("9")
                                              .errMessage("Option needs to lie between 1-8")
                                              .testCaseName("Invalid option")
                                              .build();

    return Stream.of(testCase1, testCase2);
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