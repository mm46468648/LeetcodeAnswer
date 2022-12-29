//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 801 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//java:字符串的排列
public class PermutationInString{
    public static void main(String[] args){
        Solution solution = new PermutationInString().new Solution();
        solution.checkInclusion("abcdxabc","abcdeabcdx");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> s1H = new HashMap<>();
        HashMap<Character,Integer> needH = new HashMap<>();

        for (char c : s1.toCharArray()) {
            needH.put(c,needH.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int valid = 0;
        int len = Integer.MAX_VALUE;


        while (right<s2.length()){
            char c = s2.charAt(right);
            right++;

            if(needH.containsKey(c)){
                s1H.put(c,s1H.getOrDefault(c,0)+1);
                if(needH.get(c).equals(s1H.get(c))){
                    valid++;
                }
            }

            while (right - left >= s1.length()){
                if(valid == needH.size()){
                    return true;
                }
                char c1 = s2.charAt(left);
                left++;
                if(needH.containsKey(c1)){
                    if(needH.get(c1).equals(s1H.get(c1))){
                        valid--;
                    }
                    s1H.put(c1,s1H.getOrDefault(c1,0) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

