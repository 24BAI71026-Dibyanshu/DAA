class Solution {

    static Boolean solve(int arr[] ,int i, int sum  , int curr ){
        
        if (sum == curr ) return true ;
        if(i>=arr.length)return false ;
        if (sum<curr ) return false;
        return solve(arr , i+1 , sum , curr + arr[i]) ||
        solve(arr , i+1 , sum , curr );
        
    }


    static Boolean isSubsetSum(int arr[], int sum) {
        
        return solve(arr , 0, sum ,0);
        
    }
}
