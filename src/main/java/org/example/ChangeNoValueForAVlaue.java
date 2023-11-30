package org.example;

public class ChangeNoValueForAVlaue {
    
    public static String changeValue(String input){
        String modified;
        modified = input.replace(" ", "$32"); //BigO(n)
        return modified;
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println( ChangeNoValueForAVlaue.changeValue("Hey i am Luis "));

        System.out.println(ChangeNoValueForAVlaue.addBinary("001", "11"));

    }
}
