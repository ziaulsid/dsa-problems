import java.util.*;
import java.util.stream.*;

class TopKAwardedHotels {

    /*
     * Complete the 'awardTopKHotels' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING positiveKeywords
     *  2. STRING negativeKeywords
     *  3. INTEGER_ARRAY hotelIds
     *  4. STRING_ARRAY reviews
     *  5. INTEGER k
     */

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {

        List<String> positiveReviewsList = Arrays.asList(positiveKeywords.split(" "));
        List<String> negativeReviewsList = Arrays.asList(negativeKeywords.split(" "));
        Map<Integer, Integer> positiveReviewMap = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++) {
            int hotelId = hotelIds.get(i);
            List<String> review = Arrays.asList(reviews.get(i).split(" "));
            int currentPositive = (int) review.stream()
                    .filter(token -> positiveReviewsList.contains(token))
                    .count();
            int currentNegative = (int) review.stream()
                    .filter(token -> negativeReviewsList.contains(token))
                    .count();
            int total = currentPositive * 3 + currentNegative * -1;
            int previous = positiveReviewMap.getOrDefault(hotelId, 0);
            positiveReviewMap.put(hotelId, previous + total);
        }
        List<Integer> topHotel = positiveReviewMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return topHotel;

    }

}

