import java.util.HashSet;
import java.util.Set;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        Set<Integer> prev = new HashSet<>();
        prev.add(arr[0]);
        int res = Math.abs(target - arr[0]);
        for(int i = 1; i < n; i++) {
            res = Math.min (res, Math.abs( target - arr[i]));
            Set<Integer> cur = new HashSet<>();
            cur.add(arr[i]);
            for(int x : prev){
                cur.add(x & arr[i]);
                res = Math.min (res, Math.abs( target - (x & arr[i])));
            }
            prev = cur;
        }

        return res;
    }
}