import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split(" ");
        for(String word : words){
            boolean flag = true;
            for(int i = 0; i < brokenLetters.length(); i++){
                if(word.contains(brokenLetters.charAt(i) + "")){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;

    }
}
