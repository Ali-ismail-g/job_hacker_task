package utility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validator {
	private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	
	private static final String EMAIL_REGEX =
            "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	
    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidPassword(final String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
    public static boolean isValidEmail(final String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

}
