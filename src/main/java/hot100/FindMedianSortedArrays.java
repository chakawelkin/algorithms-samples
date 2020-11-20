package hot100;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if (sum % 2 == 0){
            return ((double) findMedian(nums1,0,nums2,0,sum / 2) + (double) findMedian(nums1,0,nums2,0,sum / 2 + 1)) / 2;
        }
        return findMedian(nums1,0,nums2,0,(sum + 1) /2);
    }

    private int findMedian(int[] nums1,int left1,int[] nums2,int left2,int k){
        if (left1 >= nums1.length){
            return nums2[left2 + k - 1];
        }
        if (left2 >= nums2.length){
            return nums1[left1 + k -1];
        }
        if (k == 1){
            return Math.min(nums1[left1],nums2[left2]);
        }
        int mid1 = left1 + k / 2 - 1 < nums1.length ? nums1[left1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = left2 + k / 2 - 1 < nums2.length ? nums2[left2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2){
            return findMedian(nums1,left1 + k / 2, nums2 ,left2,k - k /2);
        }
        return findMedian(nums1,left1,nums2,left2 + k / 2,k - k / 2);
    }

}