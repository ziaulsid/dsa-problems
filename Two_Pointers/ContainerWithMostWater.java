public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int currArea = 0;

        int start = 0;
        int end = height.length-1;

        while(start < end){
            currArea = Math.min(height[start], height[end]) * (end-start);

            maxArea = Math.max(currArea, maxArea);
            if(height[start] < height[end])start++;
            else end--;
        }
        return maxArea;


    }
}
