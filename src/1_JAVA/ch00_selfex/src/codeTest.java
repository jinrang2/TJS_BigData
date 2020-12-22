import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class codeTest {


    public static void main(String[] args) throws Exception{

        String[] phoneArray = phoneNumberSplit("019-1234-1234");
        System.out.println(phoneArray[0]);
        System.out.println(phoneArray[1]);
        System.out.println(phoneArray[2]);
    }


    public static String[] phoneNumberSplit(String phoneNumber) throws Exception{

        //Pattern tellPattern = Pattern.compile( "^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})");
    	Pattern tellPattern = Pattern.compile( "^(01\\d{1})-?(\\d{3,4})-?(\\d{4})");

        Matcher matcher = tellPattern.matcher(phoneNumber);
        if(matcher.matches()) {
            //정규식에 적합하면 matcher.group으로 리턴
            return new String[]{ matcher.group(1), matcher.group(2), matcher.group(3)};
        }else{
            //정규식에 적합하지 않으면 substring으로 휴대폰 번호 나누기
            
            String str1 = phoneNumber.substring(0, 3);
            String str2 = phoneNumber.substring(3, 7);
            String str3 = phoneNumber.substring(7, 11);
            return new String[]{str1, str2, str3};
        }
    }
}