import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestvalidParenthesis {

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
//         remove valid pair
        removeValidParenthesis(st, s);
        if(st.isEmpty())
            return s.length();

        List<Integer> ls = new ArrayList<>();
        formArrayFromStack(st, ls, s);
        int max = 0;
        for (int i = 1; i <ls.size() ; i++) {
            int prev = ls.get(i-1);
            max = Math.max(max, ls.get(i) - prev -1);

        }
        return max;


    }

    private void formArrayFromStack(Stack<Integer> st, List<Integer> ls, String s ) {
        ls.add(0,s.length() );
        while (!st.isEmpty()){
            ls.add(0, st.pop());
        }
        ls.add(0, -1);
    }

    private void removeValidParenthesis(Stack<Integer> st, String s) {
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if( ch == '('){
                st.push(i);

            }
            else {
                if( st.isEmpty() || s.charAt(st.peek())== ')'){
                    st.push(i);

                }
                else {
                    st.pop();
                }
            }


        }
    }

    // optimised approach
//    public int longestValidParentheses(String s) {
//        Stack<Integer> st = new Stack<>();
//        int max =0;
//        st.push(-1);
//
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if( ch == '('){
//                st.push(i);
//
//            }
//            else {
//                st.pop();
//                if( st.isEmpty()){
//                    st.push(i);
//                }
//
//                max = Math.max(max, i - st.peek());
//            }
//
//        }
//        return  max;
//
//    }
}
