import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExpTest {


    public static void main(String[] args) throws Exception{

        String[] phoneArray = phoneNumberSplit("019-1234-1234");
        System.out.println(phoneArray[0]);
        System.out.println(phoneArray[1]);
        System.out.println(phoneArray[2]);
    }


    public static String[] phoneNumberSplit(String phoneNumber) throws Exception{

    	Pattern tellPattern = Pattern.compile( "^(01\\d{1})-?(\\d{3,4})-?(\\d{4})");

        Matcher matcher = tellPattern.matcher(phoneNumber);
        if(matcher.matches()) {
            return new String[]{ matcher.group(1), matcher.group(2), matcher.group(3)};
        }else{
            String str1 = phoneNumber.substring(0, 3);
            String str2 = phoneNumber.substring(3, 7);
            String str3 = phoneNumber.substring(7, 11);
            return new String[]{str1, str2, str3};
        }
    }
}