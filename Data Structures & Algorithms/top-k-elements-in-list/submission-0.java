class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // use hash map to keep track of count
        //queue of size k k =3    2(2) 1(1) 3(1)  [1,4,2,4,2,4,3,4,3,3] 3(3) 2(2)
        // Comparator<Integer> c = (a, b) -> b - a; // max-heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        Comparator<Map.Entry<Integer, Integer>> c = (a, b) -> b.getValue() - a.getValue();
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(c);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            
            map.computeIfPresent(i, (key, v) -> v = v +1);
            map.computeIfAbsent(i, key -> 1);

        }

        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            maxHeap.add(e);
        }

        int[] topk = new int[k];

        for (int i = 0; i < topk.length; i++) {
            Map.Entry<Integer,Integer> e = maxHeap.poll();
            System.out.println(e);

            topk[i] = e.getKey();
        }

        return topk;
    }
}
