package org.example;

public class Mediana {


    //METODO APPROVATO ---------------------------------
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        int left = 0;
        int right = m;
        if ((nums1.length !=0 || nums2.length!=0)) {
            while (left <= right) {

                int partitionNums1 = (left + right) / 2;
                int partitionNums2 = (totalLength + 1) / 2 - partitionNums1;
                int maxLeftNums1;
                if (partitionNums1 == 0) {
                    maxLeftNums1 = Integer.MIN_VALUE;
                } else {
                    maxLeftNums1 = nums1[partitionNums1 - 1];
                }

                int minRightNums1;
                if (partitionNums1 == m) {
                    minRightNums1 = Integer.MAX_VALUE;
                } else {
                    minRightNums1 = nums1[partitionNums1];
                }

                int maxLeftNums2 = nums2[partitionNums2 - 1];

                int minRightNums2;
                if (partitionNums2 == n) {
                    minRightNums2 = Integer.MAX_VALUE;
                } else {
                    minRightNums2 = nums2[partitionNums2];
                }

                if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                    if (totalLength % 2 == 0) {
                        return (double) (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0;
                    } else {
                        return (double) Math.max(maxLeftNums1, maxLeftNums2);
                    }
                } else if (maxLeftNums1 > minRightNums2) {
                    right = partitionNums1 - 1;
                } else {
                    left = partitionNums1 + 1;
                }
            }
        }
        return 0;
    }


    //alternativa al metodo approvato -------------------------------------
   /* public double findMedianSortedArrays(int [] nums1, int[] nums2){
        //1. controllare se gli array sono vuoti
        if (nums1.length == 0 && nums2.length == 0 ){
            return 0;
        }else{
            //2 unire i due array
            int [] combineArray = new int[nums1.length+nums2.length];

            for (int i = 0; i < nums1.length; i++) {
                combineArray[i] = nums1[i];
            }

            for (int i = 0; i < nums2.length; i++) {
                combineArray[nums1.length+i] = nums2[i];
            }

            //3. ordinare in ordine crescente l'array
            for (int i = 0; i < combineArray.length; i++) {
                for (int j = 1; j < (combineArray.length - i); j++) {
                    if (combineArray[j - 1] > combineArray[j]) {
                        //  swap array’s elements using temporary element
                        int temp = combineArray[j - 1];
                        combineArray[j - 1] = combineArray[j];
                        combineArray[j] = temp;
                    }
                }
            }
            double result;
            if (combineArray.length % 2 == 0){//5. se l'array è pari prelevare i due elementi centrali e dividerli per 2
                int posizione = combineArray.length / 2;
                result =  (double) (combineArray[posizione - 1] + combineArray[posizione]) / 2;
            } else {//6. se l'array è dispari prelevare l'elemento di mezzo
                int posizione = (combineArray.length / 2);
                result = combineArray[posizione];
            }
            return result;
        }
    }*/
}
