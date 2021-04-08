import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasSpecialCharacter
{
   public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        Pattern pattern=Pattern.compile("[^a-zA-Z0-9]"); //say you only want alphabets "[^a-zA-Z]"
        Matcher matcher =pattern.matcher(str);
        if(matcher.find())
            System.out.println("given string has special characters");
        else
            System.out.println("given String has no special characters ");
    }
}