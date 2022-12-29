////////////一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
////////////
//////////// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
////////////
//////////// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
////////////
//////////// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
////////////
//////////// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标
//基因
////序列
//////所需
////////的最
//////////少变
////////////化次数。如果无法实现目标变化，请返回 -1。 
////////////
//////////// 注意： 
////////////
//////////// 
//////////// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
//////////// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
//////////// 假定起始基因序列与目标基因序列是不一样的。 
//////////// 
////////////
//////////// 
////////////
//////////// 示例 1： 
////////////
//////////// 
////////////start: "AACCGGTT"
////////////end: "AACCGGTA"
////////////bank: ["AACCGGTA"]
////////////
////////////返回值: 1
//////////// 
////////////
//////////// 示例 2： 
////////////
//////////// 
////////////start: "AACCGGTT"
////////////end: "AAACGGTA"
////////////bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
////////////
////////////返回值: 2
//////////// 
////////////
//////////// 示例 3： 
////////////
//////////// 
////////////start: "AAAAACCC"
////////////end: "AACCCCCC"
////////////bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
////////////
////////////返回值: 3
//////////// 
//////////// Related Topics 广度优先搜索 哈希表 字符串 👍 109 👎 0
//////////
////////
//////
////
//

package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//java:最小基因变化
public class P433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new P433MinimumGeneticMutation().new Solution();

        solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> bankSet = new HashSet();
            for (int b = 0; b < bank.length; b++) {
                bankSet.add(bank[b]);
            }

            String[] gen = {"A", "C", "G", "T"};
            Deque<String> deque = new LinkedList();
            Set<String> visited = new HashSet();
            deque.add(start);
            visited.add(start);

            int step = 0;


            while (!deque.isEmpty()) {

                int size = deque.size();
                for (int k = 0; k < size; k++) {

                    String cur = deque.poll();
                    visited.add(cur);


                    if (cur.equals(end)) {
                        return step;
                    }

                    //构建下一层
                    for (int i = 0; i < cur.length(); i++) {
                        StringBuilder sb = new StringBuilder(cur);
                        for (int j = 0; j < gen.length; j++) {
                            String repleace = sb.replace(i, i + 1, gen[j]).toString();
                            if (bankSet.contains(repleace) && !visited.contains(repleace)) {
                                deque.add(repleace);
                            }
                        }
                    }

                }

                step++;
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

