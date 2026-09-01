/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left=0;
        int right=mountainArr.length()-1;
        int peak=0;
        //finding peak
        while(left<right){
            int mid=left+(right-left)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                left=mid+1;
            }
            else{
                right=mid;
            }
             peak=right;
        }

        //run binary search from start to peak
        
        int start =0;
        int end=peak;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)>target){
            end=mid-1;
            }
            else {
                start=mid+1;
            }

        }
        int st=peak;
        int en=mountainArr.length()-1;
        while(st<=en){
            int mid=st+(en-st)/2;
            if(mountainArr.get(mid)==target){
                return mid;
            }
            else if(mountainArr.get(mid)>target){
            st=mid+1;
            }
            else {
                en=mid-1;
                
            }

        }

        return -1;
    }
}