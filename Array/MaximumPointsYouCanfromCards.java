class MaximumPointsYouCanfromCards {    
    //Find sub array with sum as minimum value
    public int maxScore(int[] cardPoints, int k) {
        
        int sum = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int curr_sum = 0;
        int length = 0;
        for(end = 0; end < cardPoints.length; end++){
            
            curr_sum += cardPoints[end];
            length = end - start + 1;
            if(length == cardPoints.length - k){
                sum = Math.min(sum, curr_sum);
                curr_sum -= cardPoints[start++];
            }            
        }
        int totalSum = 0;
        for(int point : cardPoints){
            totalSum += point;
        }
        if(sum == Integer.MAX_VALUE) sum = 0;
        return totalSum - sum;
    }
}
