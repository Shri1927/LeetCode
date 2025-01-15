import java.util.Scanner;

public class day_01_string {
    
    public static void main(String[] args) {
        // String name1 = "Shri";
        // String name2 = "Shri";
        // String name3 = "Shri";
        // String name4 = name1;
        // System.out.println(name1 == name2);
        // System.out.println(name2 == name3);
        // System.out.println(name3 == name4);
        // System.out.println(name4 == name1);

        // String  name1 = new String("Shri");
        // System.out.println(name1);

        // String name2 = name1;
        // System.out.println(name2);

        // name2 = "unknown";Shri
        // System.out.println(name2);

        // Scanner obj = new Scanner(System.in);
        // System.out.println("Enter the Line");
        // String Line = obj.nextLine();
        // System.out.println("Enter the Word");
        // String word = obj.next();
        // System.out.println("word is "+word);
        // System.out.println("Line is "+Line);


        String str = "Shri Bidave";

        // System.out.println(str.toLowerCase());
        // System.out.println(str.toUpperCase());
        // System.out.println(str.charAt(5));

        // char ch[] = str.toCharArray();

        // for(int i=0; i<str.length(); i++){
        //     System.out.print(ch[i]);
        // }
        // System.out.println();
        // System.out.println("shrishail".compareTo("shri"));
        // System.out.println("shri".compareTo("shrishail"));

        // String choices = "eat, play, sleep, study";
        // String[] choice = choices.split(", ");
        // for(int i=0; i<choice.length; i++){
        //     System.out.println(choice[i]);
        // }

        String email1 = "shri@gmail.com";
        String email2 = "shri@hotmail.com";

        String emailArr[] = email1.split("@");
        String lastpart = emailArr[emailArr.length-1];
        int dotIndex = lastpart.lastIndexOf(".");

        System.out.println(lastpart.substring(0, dotIndex));


    }
}
