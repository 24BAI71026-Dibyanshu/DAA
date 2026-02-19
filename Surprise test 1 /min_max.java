 public static int maxMin(int k, List<Integer> arr) {
     Collections.sort(arr);
    
     int min = Integer.MAX_VALUE;

    for (int i = 0; i <= arr.size() - k; i++) {
        
        int curr = arr.get(i + k - 1) - arr.get(i);

        if (curr < min) {
            min = curr;
        }
    }

    return min;
}


}
