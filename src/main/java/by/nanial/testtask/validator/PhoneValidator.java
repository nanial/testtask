package by.nanial.testtask.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_PATTERN =
            "^[375]+([0-9]{9})$";

    public PhoneValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    public boolean validate(final String phone) {
        matcher = pattern.matcher(phone);

        return matcher.matches();
    }
}
