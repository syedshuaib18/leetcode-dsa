
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int  left=0;
        int right=mountainArr.length()-1;
        int peak =findPeak(mountainArr,left,right);
        int ans=searchAscending(mountainArr,target,left,peak);
        if(ans!=-1)return ans;
        return searchDescending(mountainArr,target,peak+1,right);
    }
    private int findPeak(MountainArray a,int left,int right){
        while(left<right){
            int mid=left+(right-left)/2;
            if(a.get(mid)<a.get(mid+1)){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
    private int searchAscending(MountainArray a,int target,int left,int right ){
     
     while(left<=right){
        int mid=left+(right-left)/2;
         if(a.get(mid)==target){
             return mid;}
             else if(a.get(mid)<target){
                 
             left=mid+1;
         }
         else{
             right=mid-1;
         }
     }
     
     
     return -1;
        
    }
    private int searchDescending(MountainArray a,int target,int left,int right){
        
        while(left<=right){
            int mid=left+(right-left)/2;
            if(a.get(mid)==target){
                return mid;
            }
            else if(a.get(mid)>target){
                 
             left=mid+1;
         }
         else{
             right=mid-1;
         }
         }
         return -1;
     
          }
        
        
        

        
        
    }
    
    
