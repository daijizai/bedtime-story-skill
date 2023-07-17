package asia.daijizai.hotlist.common.config;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/12 19:05
 * @description
 */

public class Main {

    public static void main(String[] args) {
        int[] nums=new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i]=i;
        }
        int idx=handle(nums,2);
        System.out.println(idx);
    }

    public static int handle(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                //说明target在nums[mid]的左边
                r=mid-1;
            }else{
                //说明target在nums[mid]的右边
                l=mid+1;
            }
        }
        return -1;
    }
}
