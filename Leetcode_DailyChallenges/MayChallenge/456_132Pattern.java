package Leetcode_DailyChallenges.MayChallenge;

import java.util.*;

class Pair {
    int i;
    int min;

    public Pair(int i, int min) {
        this.i = i;
        this.min = min;
    }
}

class Solution_132 {
    /*
     * Working solution using Monotonic Decreasing Stack
     */
    public boolean find132pattern2(int[] nums) {
        // Solve using a monotonic stack solution
        int min = Integer.MAX_VALUE;
        Deque<Pair> st = new LinkedList<>();
        // We first push the first element into our stacl
        if (nums[0] < min) {
            min = nums[0];
        }
        st.push(new Pair(nums[0], min));

        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] >= st.peek().i) {
                st.pop();
            }
            if (!st.isEmpty() && nums[i] < st.peek().i && nums[i] > st.peek().min) {
                return true;
            }
            st.push(new Pair(nums[i], min));
            min = Math.min(min, nums[i]);

        }
        return false;
    }

    // So here again we need two binary searches ig.
    public static boolean binarySearch(int[] arr, int low, int high) {
        // int low = 0;
        // int high = arr.length-1;
        int n = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[(mid + 1) % n] && arr[mid] > arr[(mid + n - 1) % n]) {
                // if(arr[(mid+1)%n] < arr[(mid+n-1)%n]) return false;
                return true;
            }
            // The question in the binary search is when do we do the split, maybe it does
            // not matter since we are doing the search in two directions anyway
            // Also we are at all times looking for 3 characters right so if the lenght is
            // smaller than 3 we just return false
            // If the element on the right is greater than we search on the left side
            else if (arr[mid] < arr[(mid + 1) % n]) {
                high = mid;
            } else if (arr[mid] < arr[(mid + n - 1) % n]) {
                low = mid;
            }
        }
        System.out.print("This false");
        return false;

    }

    public boolean find132pattern(int[] arr) {
        // Now we do what in our primary method, we need to understand where the split
        // happens and search on both sides, if in case we end up
        // finding the split at first we can just return true
        int low = 0;
        int high = arr.length - 1;
        if (binarySearch(arr, low, high)) {
            int mid = low + (high - low) / 2;
            if (arr[mid + 1] > arr[mid - 1]) {
                System.out.print("This prints");
                return true;
            } else {
                // We search on both sides
                boolean p1 = binarySearch(arr, mid, high);
                boolean p2 = binarySearch(arr, low, mid);

                if (p1 == true) {
                    System.out.print("this true");
                    return true;
                } else if (p2 == true) {
                    return true;
                }
                return false;
            }
        }

        return false;

    }
}