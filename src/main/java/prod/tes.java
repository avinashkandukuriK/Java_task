package prod;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tes {
    public static void main(String[] args) {

        System.out.println("hello");
        stringreverse("avinash");
        }

        public static void checkandprinti(String value){
        String[] splitvalue = value.split(" ");
            for(String x : splitvalue) {
                if(x.contains("i")){
                    System.out.println(x);
                }
            }
        }

        public static void checkfor4digit(String value){
            Pattern pattern = Pattern.compile("\\d[4]", Pattern.CASE_INSENSITIVE);
            Pattern pattern2 = Pattern.compile("\\[a-z,A-z]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher("Visit W3Schools!");
            boolean matchFound = matcher.find();

        if(value == ("\\d[4]") && value == ("\\[a-z,A-z]")){
            System.out.println("it's a valid passcode");
        }else{
            System.out.println("it's a not valid passcode");
        }

        }

        public static void checkforvowles(String value){
        String vlll = "I am a good programmer";
        String[] splitvalue = vlll.split("");

        String[] vowles = {"a","e","i","o","u"};
            for (String x : vowles) {
                if(value.contains(x)){
                    System.out.println("This String has vowles : " + x);
                    break;
                }
            }
        }

        public static void stringreverse(String value){
            String newstring = "";
            for(int i= value.length()-1; i >= 0; i--){
                newstring =  newstring + value.charAt(i) ;
            }
            System.out.println("This is a new String : " + newstring);
                StringBuffer sbr = new StringBuffer(value);
                sbr.reverse();
                System.out.println("This is a new String : " + sbr);
            }
        }


