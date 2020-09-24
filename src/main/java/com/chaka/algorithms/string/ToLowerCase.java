package com.chaka.algorithms.string;

/**
 * <a href=""></a>
 * 1、ASCCII码
 *  a-z：97-122
 *  A-Z：65-90
 *  0-9：48-57
 * 2、位运算
 */
public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] |= 32;
        }
        return String.valueOf(chars);
    }

}
