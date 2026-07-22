class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start != end) {
            System.out.println(start);
            System.out.println(end);
            int curr = numbers[start] + numbers[end];
            System.out.println(curr);
            if(curr == target) {
                int[] a = {start + 1, end + 1};
                return a;
            } else if (curr > target) {
                end--;
            } else {
                start++;
            }

        }
        int[] a = {start, end};
        return a;
    }
}
