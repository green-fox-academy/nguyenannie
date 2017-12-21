import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class matrixElementSumTest {
    @Test
    void matrixElementsSum_Test1() {
        int[][] matrix = {{0,1,1,2}, {0,5,0,0}, {2,0,3,3}};
        assertEquals(9,matrixElementSum.matrixElementsSum(matrix));
    }

    @Test
    void matrixElementsSum_Test2() {
        int[][] matrix = {{1,1,1,0}, {0,5,0,1}, {2,1,3,10}};
        assertEquals(9,matrixElementSum.matrixElementsSum(matrix));
    }

    @Test
    void matrixElementsSum_Test3() {
        int[][] matrix = {{1,1,1}, {2,2,2}, {3,3,3}};
        assertEquals(18,matrixElementSum.matrixElementsSum(matrix));
    }

    @Test
    void matrixElementsSum_Test4() {
        int[][] matrix = {{0}};
        assertEquals(0,matrixElementSum.matrixElementsSum(matrix));
    }
}