package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];

            graph.get(preCourse).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            Integer ele = q.poll();
            order.add(ele);
            count++;

            for(Integer i : graph.get(ele)){
                if(--indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        /*If there's a cycle return empty array*/
        if(count != numCourses) return new int[0];
        int[] topOrder = new int[order.size()];
        for (int i = 0; i < topOrder.length; i++) {
            topOrder[i] = order.get(i);
        }

        return topOrder;
    }
}
