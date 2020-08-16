package com.chaka.algorithms.dfs_bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">最小基因变化</a>
 */
public class MinimumGeneticMutation {

    private int minStep = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null){
            return -1;
        }
        int step = 0;
        Set<String> visited = new HashSet<>();
        dfs(step,start,end,bank,visited);
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private void dfs(int step, String start, String end, String[] bank, Set<String> visited) {
        if (start.equals(end)){
            minStep = Math.min(minStep,step);
            return;
        }
        for (String gene : bank) {
            int diff = 0;
            for (int i = 0; i < gene.length(); i++) {
                if (start.charAt(i) != gene.charAt(i)){
                    diff++;
                }
                if (diff > 1){
                    break;
                }
            }

            if (diff == 1 && !visited.contains(gene)){
                visited.add(gene);
                dfs(step + 1, gene, end, bank, visited);
                visited.remove(gene);
            }

        }
    }

    public static void main(String[] args) {
        MinimumGeneticMutation sol = new MinimumGeneticMutation();
        int res = sol.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(res);
    }

}
