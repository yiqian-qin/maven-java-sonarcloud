import java.util.*;
import java.util.Arrays;

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            // total water capacity is less than targetCapacity, so we cannot achieve it
            return false;
        }
        Set<Pair<Integer, Integer>> visitedStates = new HashSet<>();
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(0, 0));
        while (!stack.empty()) {
            Pair<Integer, Integer> currentState = stack.pop();
            int currentJug1Water = currentState.getKey();
            int currentJug2Water = currentState.getValue();
            if (currentJug1Water + currentJug2Water == targetCapacity) {
                // targetCapacity is achieved
                return true;
            }
            if (visitedStates.contains(currentState)) {
                // already visited this state, so skip
                continue;
            }
            visitedStates.add(currentState);
            // Fill jug1 to its capacity
            stack.push(new Pair<>(jug1Capacity, currentJug2Water));
            // Fill jug2 to its capacity
            stack.push(new Pair<>(currentJug1Water, jug2Capacity));
            // Empty jug1
            stack.push(new Pair<>(0, currentJug2Water));
            // Empty jug2
            stack.push(new Pair<>(currentJug1Water, 0));
            // Pour water from jug1 to jug2
            int remainingJug2Capacity = jug2Capacity - currentJug2Water;
            int remainingJug1Water = currentJug1Water - remainingJug2Capacity;
            if (remainingJug1Water >= 0) {
                stack.push(new Pair<>(remainingJug1Water, jug2Capacity));
            } else {
                stack.push(new Pair<>(0, currentJug1Water + currentJug2Water));
            }
            // Pour water from jug2 to jug1
            int remainingJug1Capacity = jug1Capacity - currentJug1Water;
            int remainingJug2Water = currentJug2Water - remainingJug1Capacity;
            if (remainingJug2Water >= 0) {
                stack.push(new Pair<>(jug1Capacity, remainingJug2Water));
            } else {
                stack.push(new Pair<>(currentJug1Water + currentJug2Water, 0));
            }
        }
        // targetCapacity was not achieved
        return false;
    }
}
