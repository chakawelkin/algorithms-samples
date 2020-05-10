package com.chaka.algorithms.list;

/**
 * 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length < 1){
            return digits;
        }
        int len = digits.length;
        while ((digits[len -1] + 1) / 10 > 0){
            digits[len - 1] = (digits[len -1] + 1) % 10;
            if (len - 1 == 0){
                int[] dest = new int[digits.length + 1];
                dest[0] = 1;
                return dest;
            }
            len--;
        }
        digits[len -1] = digits[len - 1] + 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,9};
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(array);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

}
