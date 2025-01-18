## Strings : 
   - String is a sequence of characters.
   - Strings are enclosed in single quotes or double quotes.
   - Strings are immutable, meaning they cannot be changed after they are created.
   - Strings can be concatenated using the + operator.
   - Strings are class in java.
   - In array we are able to pass the values by referencing to another variable but in string we are not able to pass the values by referencing to another variable.
   - Rather than referencing it creates a new space in memory and copies the values from the original string to the new string.
   - SCP : https://app.eraser.io/workspace/feCi9zjkiFvu6coPn0p8

----------------------------------------------------------------------------------------------------------------------------------------------

...Difference Between == and .equals() in Java String Comparison...

In Java, both the == operator and the .equals() method are used to compare strings, but they serve different purposes and operate in distinct ways. Understanding these differences is crucial for effective string manipulation in Java.

1. Definition and Purpose
== Operator: This operator is used to compare the reference equality of two objects. It checks whether two references point to the exact same object in memory. If both references point to the same memory location, == returns true; otherwise, it returns false14.
.equals() Method: This method is designed for content equality comparison. It checks whether two objects are logically equivalent by comparing their actual content (the sequence of characters in the case of strings). If the contents are identical, .equals() returns true25.

2. Usage Context
==: Typically used when you want to check if two references are identical, i.e., they refer to the same object instance. It can be used with both primitive types and object references35.
.equals(): Used when you need to compare the values or contents of two objects. This method cannot be used directly with primitive types; it is applicable only to objects24.

----------------------------------------------------------------------------------------------------------------------------------------------

## Program

String s1 = "hello";
String s2 = new String("hello");
String s3 = s1;

// Using ==
System.out.println(s1 == s2); // false, as they refer to different objects
System.out.println(s1 == s3); // true, as they refer to the same object

// Using .equals()
System.out.println(s1.equals(s2)); // true, as their contents are identical

-----------------------------------------------------------------------------------------------------------------

