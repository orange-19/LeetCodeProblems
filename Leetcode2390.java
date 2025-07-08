import java.util.*;


class Leetcode{
    public String removestar(String s){
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                if(result.length() > 0){
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}


public class Leetcode2390{
    public static void main(String args[]){
        String s = "le*et**cod*e";
        Leetcode lc = new Leetcode();
        String answer = lc.removestar(s);
        System.out.println(answer);
        }
    }