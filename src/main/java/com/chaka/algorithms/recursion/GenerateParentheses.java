package com.chaka.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * <a href="https://leetcode-cn.com/problems/generate-parentheses/">数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合</a>
 * 1、深度优先搜索
 * 2、广度优先搜索
 * 3、动态规划
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0){
            return list;
        }
        deepSearch("",n,n,list);
        return list;
    }

    /**
     * 深度优先搜索
     * @param currStr
     * @param left
     * @param right
     * @param res
     */
    public void deepSearch(String currStr,int left,int right,List<String> res){
        if (left == 0 && right == 0){
            res.add(currStr);
            return;
        }

        if(left > right){
            return;
        }

        if (left > 0){
            deepSearch(currStr + "(",left - 1, right,res);
        }

        if (right > 0){
            deepSearch(currStr + ")",left,right - 1,res);
        }

    }



}