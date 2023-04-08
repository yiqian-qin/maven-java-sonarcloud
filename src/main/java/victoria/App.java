import java.util.*;
import java.util.Arrays;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]); // sort courses by last day

        PriorityQueue<Integer> takenCourses = new PriorityQueue<>((a, b) -> b - a); // max heap to keep track of taken courses
        int currentDay = 0; // current day we start a course

        for (int[] course : courses) {
            int duration = course[0], lastDay = course[1];
            if (currentDay + duration <= lastDay) {
                takenCourses.offer(duration);
                currentDay += duration;
            } else if (!takenCourses.isEmpty() && takenCourses.peek() > duration) {
                // replace a longer course with this one to reduce total days taken
                currentDay += duration - takenCourses.poll();
                takenCourses.offer(duration);
            }
        }

        return takenCourses.size();
    }
}
