package DSA.assessment;

import java.util.HashSet;

/*
Array Operations: Wrestling Team
There are N wrestlers in a wrestling academy.
For the upcoming wrestling tournament, the coach of the academy decides to build a team of wrestlers out the N available wrestlers.
A team can have any number of wrestlers, but no two wrestlers in the team can have equal bodyweight.
There are only a few days left before the tournament starts.
So each of the wrestlers can either reduce their body weight by 1 Kg or increase their body weight by 1 kg.
You need to find out the maximum number of wrestlers that can be a part of the wrestling team for the tournament.
The minimum body weight of a wrestler is 50 kg to be a part of the wrestling team for the tournament.

Example: N = 7, Weights = {51 54 53 50 54 53 53} Output: 6

Explanation:
There are total 7 wrestlers.
1 wrestler having a bodyweight of 53 kg reduces his/her weight by 1 kg to make it 52 kg.
One of the wrestlers having a bodyweight of 54 kg increases his/her body weight by 1 kg to make it 55kg.
The coach will have to bench one of the wrestlers having 53 kgs.
In this way, the coach can select 6 wrestlers of different body weights to form a team for the tournament.
Hence the output is 6.
*/

class WeightSet {  // WeightSet has addWeight method that only add weight >= 50
    HashSet<Integer> set = new HashSet<>();
    void addWeight(int weight) {
        if (weight >= 50) {
            set.add(weight);
        }
        else if (weight == 49) {
            set.add(50);
        }
    }
}

public class WrestlingTeam {
    
    public static int wrestlingTeam(int[] weights) {
        WeightSet wSet = new WeightSet();
        
        // Naive approach. What if I should have subtracted 1 instead of adding, to ensure maximum number of player? 
        // Is there counter example?
        for (int w : weights) {
            if (wSet.set.contains(w)) {  // if set already contains weight
                if (!wSet.set.contains(w + 1)) {  // try weight + 1. If not already contained, add it.
                    wSet.addWeight(w + 1);
                }
                else {  // else try weight - 1
                    wSet.addWeight(w - 1);
                }
            }
            else {
                wSet.addWeight(w);
            }
        }
        System.out.println(wSet.set);
        return wSet.set.size();
    }

    public static void main(String[] args) {
        int[] weights = new int[] {51, 54, 53, 50, 54, 53, 53};
        System.out.println("Weights: {51, 54, 53, 50, 54, 53, 53}");
        System.out.println(wrestlingTeam(weights));
        
        weights = new int[] {52, 52, 52, 51, 50};
        System.out.println("Weights: {52, 52, 52, 51, 50}");
        System.out.println(wrestlingTeam(weights));
        
        weights = new int[] {49, 51, 51};
        System.out.println("Weights: {49, 51, 51}");
        System.out.println(wrestlingTeam(weights));
    }

//    public static void main(String[] args) {
//        wrestlingTeam(new int[] {51, 54, 53, 50, 54, 53, 53});
//    }
//    
//    // counting number of players with same weight
//    public static void wrestlingTeam(int[] weights) {
//        HashMap<Integer, Integer> weightToCount = new HashMap<>();
//        for (int i = 0; i < weights.length; i++) {
//            if (!weightToCount.containsKey(weights[i])) { // if map contain weight
//                weightToCount.put(weights[i], 1);
//            }
//            else {
//                weightToCount.put(weights[i], weightToCount.get(weights[i]) + 1);
//            }
//        }
//        
//        weightToCount.forEach((key, value) -> System.out.println(key + " " + value));
//    }
    
}
