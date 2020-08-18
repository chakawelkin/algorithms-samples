package com.chaka.algorithms.greedy;

/**
 * <a href="https://leetcode-cn.com/problems/lemonade-change/description/">柠檬水找零</a>
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                five++;
                continue;
            }
            if (bills[i] == 10){
                ten++;
                five--;
            }
            if (bills[i] == 20){
                if (ten > 0){
                    ten--;
                    five--;
                }else {
                    five = five - 3;
                }
            }
            if (five < 0){
                return false;
            }
        }
        return true;
    }

}
