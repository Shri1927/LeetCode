// import java.util.Scanner;

// public class day_02_string {

//     public static void main(String[] args) {
        
//         // Scanner sc = new Scanner(System.in);

//         // System.out.println("Enter a Word : ");
//         // String word1 = sc.next();
//         // System.out.println("Enter a Word Please: ");
//         // String word2 = sc.next();

//         // System.out.println("Enter a Line : ");
//         // String line1 = sc.nextLine();
//         // System.out.println("Enter a Line : ");
//         // String line2 = sc.nextLine();

//         // System.out.println("Word1 : "+word1);
//         // System.out.println("Word2 : "+word2);
//         // System.out.println("Line1 : "+line1+"$");
//         // System.out.println("Line2 : "+line2+"$");

//         // Otput :
//         // Enter a Word : 
//         // Shrishail b
//         // Enter a Word Please: 
//         // Enter a Line : 
//         // Enter a Line : 
//         // Bidave
//         // Word1 : Shrishail
//         // Word2 : b
//         // Line1 : $
//         // Line2 : Bidave$

//         // String str1 = "Shri..";
//         // int str2 = 1927;

//         // System.out.println(str1+str2);

//         // System.out.println("Shri" + 19 + 27.00); // Shri1927.0

//         // System.out.println(19 + 27.00 + "shri"); // 46.0shri

//         double num = 34.5888489;
//         System.out.printf("Number is %.2f",num); // Number is 34.59
//     }
// }

//  Programs 

import java.util.Vector;

public class day_02_string {

    static void printSubStrings(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }

    static void reverseString(String str){

        // Method 1
        // String reversed = new StringBuilder(str).reverse().toString();
        // System.out.println(reversed);

        // Method 2
        // String Str1 = "";
        // for(int i=0; i<str.length(); i++){
        //     Str1 = str.charAt(i) + Str1;
        // }
        // System.out.println(Str1);

        // Method 3
        //  char[] charArray = str.toCharArray();
        //  for (int i = 0; i < str.length() / 2; i++){
        //     char temp = charArray[i];
        //     charArray[i] = charArray[str.length() - i - 1];
        //     charArray[str.length() - i - 1] = temp;
        //  }

        //  System.out.println(charArray);

        // Method 4

        // StringBuilder ans = new StringBuilder(str);
        // int n = ans.length();

        // for(int i=0; i<n/2; i++){

        //     char firstChar = ans.charAt(i);
        //     char lastChar = ans.charAt(n-1-i);
        //     ans.setCharAt(i, lastChar);
        //     ans.setCharAt(n-1-i, firstChar);
        // }

        // System.out.println(ans.toString());

    }

    public static boolean isPalindromeString(String str){

        // Method 1 - Using StringBuilder 
        // StringBuilder revStr = new StringBuilder(str);
        // String newStr = revStr.reverse().toString();
        // if(str.equals(newStr)){
        //     System.out.println("Yes. it is");
        // }else{
        //     System.err.println("It's Not");
        // }

        // Method 2 - Using Concatatiation
        // String newStr = "";
        // for(int i=0; i<str.length(); i++){
        //     newStr = str.charAt(i) + newStr;
        // }

        // if(str.equals(newStr)){
        //     System.out.println("true");
        // }else{
        //     System.out.println("false");
        // }

        int st = 0;
        int end = str.length() - 1;

        while (st < end) {
            if(str.charAt(st) != str.charAt(end)){
                return false;
            }

            st++;
            end--;
        }

        return true;

    }

    static String reverseWord(String str){
       
        String [] words = str.split(" ");
        String result="";
        for(int i=0; i<words.length; i++){
 
            if(words[i].length() == 0){
                continue;
            }

            if(result.length() == 0){
                result += words[i];
            }else{
                result += " " + words[i];
            }

        }
        return result;
    }

    static void reverse(String str){
        String [] words = str.split(" ");
        String result="";
        for(int i=words.length-1; i>=0; i--){
            if(words[i].length() == 0){
                continue;
            }
            if(result.length() == 0){
                result += words[i];
            }else{
                result += " " + words[i];
            }
        }

        StringBuilder revStr = new StringBuilder(result);
        String newStr = revStr.reverse().toString();
        System.out.println(newStr+"*");
    }


// Optimal Sol : 
    // public String reverseWords(String s) {
    //     String [] words = s.split(" ");
    //     // String result="";
    //     StringBuilder result = new StringBuilder();
    //     for(int i=words.length-1; i>=0; i--){
    //         if(words[i].length() == 0){
    //             continue;
    //         }
    //         if(result.length() == 0){
    //             result.append(words[i]);
    //         }else{
    //             result.append(" ");
    //             result.append(words[i]);
    //         }
    //     }
    //     return result.reverse().toString();
    // }
    

    static void wordrev(String s){
        // String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        int si = s.length()-1;
        while(si >= 0){
            while( si >= 0 && s.charAt(si) == ' '){
                si--;
            }
            if(si < 0){
                break;
            }
            int ei = si;
            while( si >= 0 && s.charAt(si) != ' '){
                si--;
            }
            if(result.length() == 0){
                result.append(s.substring(si+1, ei+1));
            }else{
                result.append(" ");
                result.append(s.substring(si+1, ei+1));
            }

        }
    }

    static void isAnagram(String s, String t) {

        if(s.length() != t.length()){
            System.out.println("false");
            return;
        }
       
        int freq[] = new int[26];
        int indexS = 0;
        int indexT = 0;
        int len = s.length();
        while(indexS < len && indexT < len){
            
            int freqChars = s.charAt(indexS) - 97;
            freq[freqChars] += 1;

            int freqCharT = t.charAt(indexT) - 97;
            freq[freqCharT] -= 1;
            
            indexS++;
            indexT++;

        }

        for(int i=0; i<freq.length; i++){
            if(freq[i] != 0){
                System.out.println("false");
                return;
            }
        }
        
        System.out.println("true");
    }
    
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "acbd";
        isAnagram(str2 , str1);  
    }
}