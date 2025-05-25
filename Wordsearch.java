public class Wordsearch {

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n  ; j++) {
                if( board[i][j] == word.charAt(0)  && find(i, j, word, 0, board)){
                    return true;
                }

            }

        }
        return false;


    }

    public static boolean find( int i, int j, String word, int wordIdx,char[][] board ){
        if( wordIdx == word.length()) return true;

        if( i < 0  || j < 0 || i > board.length || j> board[0].length || board[i][j] == '$' || board[i][j] != word.charAt(wordIdx))
            return false;

        char temp = board[i][j];
        board[i][j] = '$';

        boolean found = find(i + 1, j, word, wordIdx + 1, board) ||
                find(i , j + 1, word, wordIdx + 1, board) ||
                find(i -1, j , word, wordIdx + 1, board) ||
                find(i , j -1 , word, wordIdx + 1, board) ;

        board[i][j] = temp;
        return found;

    }
}
