import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> main_stack = new Stack<>();
    Stack<int[]> min_stack = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {

        main_stack.push(x);

        if(min_stack.size() == 0 || min_stack.peek()[0] > x){
            min_stack.push(new int[]{x,1});
        }else if(min_stack.peek()[0] == x){
            min_stack.peek()[1]++;
        }
    }

    public void pop() {
        if(main_stack.pop() == min_stack.peek()[0]) {

            if(min_stack.peek()[1] > 1) min_stack.peek()[1]--;
            else min_stack.pop();
        }
    }

    public int top() {
        return main_stack.peek();
    }

    public int getMin() {
        return min_stack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

