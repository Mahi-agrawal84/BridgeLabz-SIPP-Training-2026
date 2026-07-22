package Training.DSA.Heaps;

import java.util.PriorityQueue;

public class lastStoneweight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        lastStoneweight obj = new lastStoneweight();

        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println(obj.lastStoneWeight(stones));
    }
}
