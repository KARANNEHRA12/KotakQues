import java.util.HashSet;

public class LongestCommonSequence {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        if( s.length() == 0 )
            return 0;
        int l =0 ;

        int len =0;
        int currlen =0;
        for( int r =0 ; r < s.length(); r++){

            if(hs.contains(s.charAt(r))){
                while (l < r && hs.contains(s.charAt(r))) {
                    hs.remove(s.charAt(l));
                    l++;
                }

            }

            hs.add(s.charAt(r));
            len = Math.max(len, r - l + 1);
        }
        return len;

    }
}
