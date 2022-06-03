// heap sort is a special sort that takes 2nlogn + n time
public class HeapSort {
    // min comes first
    public static void minSort(int[] input) {
        int[] heap = new int[input.length + 1];
        // add every value
        for (int i = 1; i < input.length + 1; i++) {
            // add the new one at the next place
            heap[i] = input[i - 1];
            // compare new num with its parent
            int num = i;
            while(heap[num] > heap[num/2] && num!=1) {
                int temp = heap[num/2];
                heap[num/2] = heap[num];
                heap[num] = temp;
                num /= 2;
            }
        }

        // switch last and first
        for (int i = input.length; i > 1; i--) {
            int temp = heap[i];
            heap[i] = heap[1];
            heap[1] = temp;
            // compare last to its children and take the largest to the top.
            int num = 1;
            while((num*2 <= i - 1 && heap[num] < heap[num*2])
                    || (num*2 + 1 <= i - 1 && heap[num] < heap[num*2 + 1])) {
                // if first child is larger

                if(!(num*2 + 1 <= i - 1) //when second doesn't exist
                        || heap[num*2] > heap[num*2+1]) {
                    // swap
                    temp = heap[num];
                    heap[num] = heap[num*2];
                    heap[num*2] = temp;
                    num *= 2;
                } else {
                    // swap
                    temp = heap[num];
                    heap[num] = heap[num*2 + 1];
                    heap[num*2+1] = temp;
                    num = num * 2 + 1;
                }
            }
        }

        System.arraycopy(heap, 1, input, 0, input.length + 1 - 1);
    }
}
