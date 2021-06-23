package problem.solving.stack;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Solution42586Test {
    
    @Test
    public void test() {
        Solution42586 target = new Solution42586();

        // int[] progresses = new int[] {93, 30, 55};
        // int[] speeds = new int[] {1, 30, 5};

        int[] progresses = new int[] {95, 90, 99, 99, 80, 99};
        int[] speeds = new int[] {1, 1, 1, 1, 1, 1};

        int[] answer = target.solution(progresses, speeds);
        
        System.out.println(Arrays.toString(answer));
    }
}
