//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2260 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:最小覆盖子串
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution3 {
        public String minWindow(String s, String t) {

            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            int slength = s.length();
            int tlength = t.length();
            //s的频数数组
            int[] sFreq = new int[128];
            //生成t的频数数组
            int[] tFreq = new int[128];
            for (int i = 0; i < tArray.length; i++) {
                tFreq[tArray[i]]++;
            }

            int left = 0;
            int right = 0;
            int min = slength + 1;
            String minStr = "";
            while (right < slength) {
                sFreq[sArray[right]]++;
                while (contain(sFreq, tFreq)) {
                    if (right - left + 1 < min) {
                        min = right - left + 1;
                        minStr = s.substring(left, right + 1);
                    }
                    sFreq[sArray[left]]--;
                    left++;
                }

                right++;
            }

            return minStr;
        }

        boolean contain(int[] sFreq, int[] tFreg) {
            for (int i = 0; i < tFreg.length; i++) {
                if (tFreg[i] > sFreq[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        String minWindow(String s, String t) {

            //1.维护两个map记录窗口中的符合条件的字符以及need的字符
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();//need中存储的是需要的字符以及需要的对应的数量
            for (char c : t.toCharArray())
                need.put(c, need.getOrDefault(c, 0) + 1);
            int left = 0, right = 0;//双指针
            int count = 0;//count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
            int start = 0;//start表示符合最优解的substring的起始位序
            int len = Integer.MAX_VALUE;//len用来记录最终窗口的长度，并且以len作比较，淘汰选出最小的substring的len

            //一次遍历找“可行解”
            while (right < s.length()) {
                //更新窗口
                char c = s.charAt(right);
                right++;//窗口扩大
                // window.put(c,window.getOrDefault(c,0)+1);其实并不需要将s中所有的都加入windowsmap，只需要将need中的加入即可
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (need.get(c).equals(window.get(c))) {
                        count++;
                    }
                }
                //System.out.println****Debug位置
                //shrink左边界，找符合条件的最优解
                while (count == need.size()) {
                    if (right - left < len) {//不断“打擂”找满足条件的len最短值,并记录最短的子串的起始位序start
                        len = right - left;
                        start = left;
                    }
                    //更新窗口——这段代码逻辑几乎完全同上面的更新窗口
                    char d = s.charAt(left);
                    left++;//窗口缩小
                    if (need.containsKey(d)) {
                        //window.put(d,window.get(d)-1);——bug：若一进去就将window对应的键值缩小，就永远不会满足下面的if，while也会一直执行，知道left越界，因此，尽管和上面对窗口的处理几乎一样，但是这个处理的顺序还是很关键的！要细心！
                        if (need.get(d).equals(window.get(d))) {
                            count--;
                        }
                        window.put(d, window.get(d) - 1);

                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }

    }

    class Solution {
        String minWindow(String s, String t) {

            HashMap<Character,Integer> sHash = new HashMap<>();
            HashMap<Character,Integer> tHash = new HashMap<>();

            //生成t的字符频数数组
            for (char c : t.toCharArray()) {
                tHash.put(c,tHash.getOrDefault(c,0)+1);
            }

            int left = 0;
            int right = 0;
            int len = Integer.MAX_VALUE;
//            int min = len + 1;
            int start = 0;
            int valid = 0;
            while (right < s.length()){
                char c = s.charAt(right);
                right++;
                //如果有才计算,没有不添加
                if(tHash.containsKey(c)){
                    sHash.put(c,sHash.getOrDefault(c,0)+1);
                    //代表滑到了这个字符的最大个数
                    if(sHash.get(c).equals(tHash.get(c))){
                        valid++;
                    }
                }

                //右滑停止,缩小窗口
                while (valid==tHash.size()){
                    //获取最小的长度
                    if(right-left < len){
                        len = right-left;
                        start = left;
                    }

                    //移出窗口
                    char c1 = s.charAt(left);
                    left++;
                    if(tHash.containsKey(c1)){
                        if(tHash.get(c1).equals(sHash.get(c1))){
                            valid--;
                        }
                        sHash.put(c1,sHash.getOrDefault(c1,0)-1);
                    }
                }


            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}

