public class SortedMatrixDelete {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int target = 29;
        boolean found = deleteElement(matrix, target);
        if (found) {
            System.out.println("Element " + target + " deleted successfully.");
            printMatrix(matrix);
        } else {
            System.out.println("Element " + target + " not found in the matrix.");
        }
    }

    public static boolean deleteElement(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        // Search for the element
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                // Shift elements to the left in the same row
                for (int j = col; j < cols - 1; j++) {
                    matrix[row][j] = matrix[row][j + 1];
                }
                // Set the last element in the row to a default value (assuming no resizing)
                matrix[row][cols - 1] = Integer.MIN_VALUE;
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num != Integer.MIN_VALUE) {
                    System.out.print(num + " ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}