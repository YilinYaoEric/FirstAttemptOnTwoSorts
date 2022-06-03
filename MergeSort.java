public class MergeSort {
    public static void sort(int[] a) {
        int max = a.length - 1;
        int oldLength = Math.min(max, 1);
        while(oldLength!=max) {
            int newLength = Math.min(max, oldLength*2);
            int start = 0; // start of a[];

            // repeat and update start
            while(start != max) {
                int[] first = new int[Math.min(oldLength, max - start)];
                int[] second = new int[Math.max(
                        Math.min(oldLength, max - start - first.length), 0
                )];
                int totalLength = first.length + second.length;
                int firstPosition = 0;
                int secondPosition = 0;

                System.arraycopy(a, start, first, 0, first.length);

                System.arraycopy(a, start + first.length, second, 0, second.length);

                for (int i = 0; i < totalLength; i++) {
                    int aPosition = i + start;
                    // remove the smallest
                    if (firstPosition != first.length &&
                            (secondPosition == second.length || first[firstPosition] < second[secondPosition])) {
                        // first remove
                        a[aPosition] = first[firstPosition];
                        firstPosition++;
                    } else {
                        a[aPosition] = second[secondPosition];
                        secondPosition++;
                    }
                }
                start += totalLength;
            }

            oldLength = newLength;
        }
    }
}
