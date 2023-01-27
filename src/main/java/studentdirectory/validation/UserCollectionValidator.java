package studentdirectory.validation;

import studentdirectory.models.UserCollection;

public final class UserCollectionValidator {

  private UserCollectionValidator() {

  }

  private static boolean isRollNoPresent(final String rollNo) {
    return UserCollection.getInstance().isUserWithGivenRollNoPresent(rollNo);
  }

  public static void validateRollNoAbsent(final String rollNo) throws Exception {
    if (isRollNoPresent(rollNo)) {
      throw new Exception("Roll No is already present in the database");
    }
  }

  public static void validateRollNoPresent(final String rollNo) throws Exception {
    if (!isRollNoPresent(rollNo)) {
      throw new Exception("Roll No is not present in the database");
    }
  }

}
