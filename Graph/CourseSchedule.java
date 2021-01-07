package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            Integer ele = q.poll();
            count++;

            for(Integer i : graph.get(ele)){
                if(--indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return count == numCourses;
    }
}
