import java.util.*;

class Solution {
    char[] type = {'*','+','-'};

    List<Long> numbers;
    List<Character> operators;

    long answer = 0;

    public long solution(String expression) {
        boolean[] vis = new boolean[3];
        char[] select = new char[3];

        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        long num = 0;
        for(char ch : expression.toCharArray()){
            //연속된 숫자
            if(Character.isDigit(ch)){
                num = num*10+(ch-'0');
            }

            else {
                numbers.add(num);
                operators.add(ch);
                num = 0;
            }
        }
        numbers.add(num);
        perm(0,vis, select);

        return answer;
    }

    void perm(int depth, boolean[] vis, char[] select){
        if(depth==type.length){
            // 우선순위 계산
            answer = Math.max(answer, Math.abs(compute(select)));
            return;
        }

        //백트래킹 순열
        for(int i=0; i<type.length; i++){
            if(vis[i]) continue;

            vis[i] = true;

            select[depth] = type[i];
            perm(depth+1, vis, select);

            vis[i] = false;
        }
    }

    long cal(long a, long b, char ch){
        if(ch == '*') return a*b;
        else if(ch == '+') return a+b;
        else return a-b;
    }

    long compute(char[] select){
        Map<Character, Integer> map = new HashMap<>();

        //우선순위
        for(int i=0; i<select.length; i++){
            map.put(select[i], i);
        }

        Deque<Long> numStack = new ArrayDeque<>();
        Deque<Character> operStack = new ArrayDeque<>();
        numStack.push(numbers.get(0));

        for(int i=0; i<operators.size(); i++){
            char oper = operators.get(i);
            long num = numbers.get(i+1);

            // 우선순위(가로) 조건 계산
            while (!operStack.isEmpty()
                    && map.get(operStack.peek()) <= map.get(oper)){
                long b = numStack.pop();
                long a = numStack.pop();
                numStack.push(cal(a,b,operStack.pop()));
            }

            numStack.push(num);
            operStack.push(oper);
        }

        //우선순위 뒤가 높은 순
        while (!operStack.isEmpty()){
            long b = numStack.pop();
            long a = numStack.pop();

            numStack.push(cal(a,b,operStack.pop()));
        }

        return numStack.pop();
    }
}