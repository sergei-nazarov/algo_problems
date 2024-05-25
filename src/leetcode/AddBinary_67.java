package leetcode;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            if(i>=0){
                carry+=a.charAt(i--)-'0';
            }
            if(j>=0){
                carry+=b.charAt(j--)-'0';
            }
            sb.append(carry%2);
            carry/=2;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
//        System.out.println(new AddBinary_67().addBinary("1010", "1011"));
        System.out.println(new AddBinary_67().addBinary("1", "1011"));

    }

}
