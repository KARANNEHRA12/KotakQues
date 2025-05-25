public class CanPalindrome {

    static  boolean isPalindrome(String s ){
        int l =0; int r = s.length() -1;
        while( l< r){
            if(s.charAt(l) != s.charAt(r)){
                return false;


            }
            l++;
            r--;

        }
        return true;
    }

    static boolean isPalindrome(String s, int left, int right){
        while (left< right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
    public static boolean canFormPalindrome(String a, String b) {
        int n = a.length();

        for (int i = 0; i < n; i++) {
            String combined1 = a.substring(0,i)+ b.substring(i);
            String combined2 = b.substring(0,i)+ a.substring(i);

            if(isPalindrome(combined1)|| isPalindrome(combined2)){
                return true;
            }


        }
        return false;


    }
    public static void main(String[] args) {
        String a = "abcba";
        String b = "xyzzy";

        System.out.println("Can form palindrome? " + checkPalindromeFormation(a, b));
    }

    // optmized approach
    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public static boolean check(String a, String b){

        int left =0, right = a.length() -1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }

        return isPalindrome(a, left, right)|| isPalindrome(b, left, right);
    }

}
