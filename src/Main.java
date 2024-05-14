import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);
        List<Integer> weightOfGoats = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList());
        int minumumWeightPerCourse = weightOfGoats.stream().mapToInt(Integer::intValue).sum() / K;

        weightOfGoats.sort(Integer::compareTo);
        Collections.reverse(weightOfGoats);
        int finalSum = 0;


        while (K > 0){
            Iterator<Integer> iterator = weightOfGoats.iterator();

            if(K == 1){
                finalSum = weightOfGoats.stream().mapToInt(Integer::intValue).sum();
                break;
            }

            Integer currentGoat = iterator.next();
            iterator.remove();

            minumumWeightPerCourse = minumumWeightPerCourse - currentGoat;
            while (minumumWeightPerCourse > 0 && iterator.hasNext()){
                Integer next = iterator.next();
                if(minumumWeightPerCourse - next >= 0){
                    minumumWeightPerCourse = minumumWeightPerCourse - next;
                    iterator.remove();
                }
            }
            K--;
        }
        System.out.println(finalSum);


    }


}