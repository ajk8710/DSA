package DSA.assessment;

import java.util.HashMap;

// There are N wrestlers in a wrestling academy.
// For the upcoming wrestling tournament, the coach of the academy decides to build a team of wrestlers out the N available wrestlers.
// A team can have any number of wrestlers, but no two wrestlers in the team can have equal bodyweight.
// There are only a few days left before the tournament starts.
// So each of the wrestlers can either reduce their body weight by 1 Kg or increase their body weight by 1 kg.
// You need to find out the maximum number of wrestlers that can be a part of the wrestling team for the tournament.

// The minimum body weight of a wrestler is 50 kg to be a part of the wrestling team for the tournament.
// 1 < = N < = 200
// 50 < = Present Body Weight of Wrestlers < = 10000

public class WrestlingTeam {

    public static void main(String[] args) {
        wrestlingTeam(new int[] {51, 54, 53, 50, 54, 53, 53});

    }
    
    public static void wrestlingTeam(int[] weights) {
        HashMap<Integer, Integer> weightToCount = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            if (!weightToCount.containsKey(weights[i])) { // if map contain weight
                weightToCount.put(weights[i], 1);
            }
            else {
                weightToCount.put(weights[i], weightToCount.get(weights[i]) + 1);
            }
        }
        
        weightToCount.forEach((key, value) -> System.out.println(key + " " + value));
    }
    
}
