package problem.solving.stack;

import java.util.Stack;

/*
    [42586] https://programmers.co.kr/learn/courses/30/lessons/42586
    스택/큐 > 기능개발 (Level 2)
*/
public class Solution42586 {

    /*
        progresses: 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
        speeds: 각 작업의 개발 속도가 적힌 정수 배열
        answer: 각 배포마다 배포되는 기능 개수
    */
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();

        int latestDeployDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            // 작업을 완료하기 위해서 필요한 작업기간
            int workingDay = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);

            if (stack.isEmpty() || (workingDay > latestDeployDay)) { 
                // stack이 비었거나, 작업기간이 최근배포날짜보다 더 걸릴경우 함께 배포를 진행하지 않고 따로 한다
                latestDeployDay = workingDay;
                stack.push(1);
            } else {
                // 작업기간이 최근 배포 날짜보다 적다면 함께 배포한다
                int deployCnt = stack.pop();
                deployCnt++;
                stack.push(deployCnt);
            }  
        }

        int[] answer = stack.stream().mapToInt(x -> x).toArray();
        return answer;
    }

}