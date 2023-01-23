package studentdirectory.testcasestructure;

public class GenericTestCaseStructure {
  private String errMessage;
  private String testCaseName;

  public String getErrMessage() {
    return errMessage;
  }

  public void setErrMessage(String errMessage) {
    this.errMessage = errMessage;
  }

  public String getTestCaseName() {
    return testCaseName;
  }

  public void setTestCaseName(String testCaseName) {
    this.testCaseName = testCaseName;
  }

  public GenericTestCaseStructure(){
    errMessage="";
    testCaseName="";
  }

}
