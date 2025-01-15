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

        StringBuilder ans = new StringBuilder(str);
        int n = ans.length();

        for(int i=0; i<n/2; i++){

            char firstChar = ans.charAt(i);
            char lastChar = ans.charAt(n-1-i);
            ans.setCharAt(i, lastChar);
            ans.setCharAt(n-1-i, firstChar);
        }

        System.out.println(ans.toString());


    }
    public static void main(String[] args) {
        String str = "abc";
        reverseString(str);   
    }
}