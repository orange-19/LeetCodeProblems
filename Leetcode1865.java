import java.util.*;

public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq;

    // Constructor to initialize nums1, nums2 and build frequency map for nums2
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq = new HashMap<>();

        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    // Add val to nums2[index] and update the frequency map
    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        nums2[index] = newVal;

        // Update frequency map
        freq.put(oldVal, freq.get(oldVal) - 1);
        if (freq.get(oldVal) == 0) {
            freq.remove(oldVal);
        }

        freq.put(newVal, freq.getOrDefault(newVal, 0) + 1);
    }

    // Count number of pairs (i, j) such that nums1[i] + nums2[j] == tot
    public int count(int tot) {
        int count = 0;

        for (int num : nums1) {
            int complement = tot - num;
            count += freq.getOrDefault(complement, 0);
        }

        return count;
    }
}

class Leetcode1865{
	// Main method for testing
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 4};

        FindSumPairs obj = new FindSumPairs(nums1, nums2);

        System.out.println("Initial count(6): " + obj.count(6)); // Expect 1 (3+3)

        obj.add(0, 1); // nums2 becomes [4, 4]

        System.out.println("After add(0, 1), count(6): " + obj.count(6)); // Expect 2 (2+4 and 3+3)
        System.out.println("count(7): " + obj.count(7)); // Expect 1 (3+4)
    }
}
