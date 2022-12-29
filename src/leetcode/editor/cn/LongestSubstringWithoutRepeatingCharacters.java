//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 8456 👎 0

package leetcode.editor.cn;
//java:无重复字符的最长子串
public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int length = s.length();
        int left = 0;
        int right = 0;
        int max = 1;
        int[] freq = new int[128];
        char[] chararray = s.toCharArray();

        while (right<length){
            freq[chararray[right]]++;
            while (freq[chararray[right]] == 2){
                freq[chararray[left]]--;
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }

    boolean checkRepeat(int[] freq){
        int index = 0;
        while (index < freq.length){
            if(freq[index] == 2){
                return true;
            }
            index++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

