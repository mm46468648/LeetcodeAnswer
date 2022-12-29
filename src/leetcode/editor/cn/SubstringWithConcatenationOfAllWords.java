//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 860 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:串联所有单词的子串
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
//        s = "barfoothefoobarman", words = ["foo","bar"]
        solution.findSubstring( "barfoothefoobarman",new String[]{"foo","bar"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();

            int len = words.length;
            int singleLen = words[0].length();
            int childLen = singleLen * len;

            int left = 0;
            int right = 0;
            while (right <= s.length()){
                if(right - left == childLen){
                    //看一下是否是异位词
                    String substring = s.substring(left, right);
                    if(isRight(substring,words)){
                        res.add(left);
                    }
                    left++;
                }
                right++;
            }

            return res;
        }

        public boolean isRight(String substring,String[] words){
            //生成hash表
            int singleLen = 0;
            HashMap<String,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                singleLen = word.length();
                hashMap.put(word,hashMap.getOrDefault(word,0)+1);
            }

            //入队
            Queue<String> queue = new LinkedList<>();

            int cur = 0;
            for (int i = 0; i < words.length; i++) {
                String temp = substring.substring(cur,cur+singleLen);
                queue.offer(temp);
                cur = cur+singleLen;
            }

            while (!queue.isEmpty()){
                String poll = queue.poll();
                Integer integer = hashMap.getOrDefault(poll,0);
                if(integer == 0){
                    return false;
                }else {
                    hashMap.put(poll,integer-1);
                }
            }
            return true;
        }

        public List<Integer> findSubstring2(String s, String[] words) {
            List<Integer> res = new ArrayList<>();

            int len = words.length;
            int childLen = words[0].length() * len;

            getAllwords(childLen, words);
            for (int i = 0; i < s.length(); i++) {
                if (i + childLen <= s.length()) {
                    String substring = s.substring(i, i + childLen);
                    if (match(substring)) {
                        res.add(i);
                    }
                }
            }
            return res;
        }
        /**
         * 判断子串是否满足条件
         *
         * @return
         */
        boolean match(String child) {
            //获取word的全排列
            for (int i = 0; i < allWord.size(); i++) {
                if (allWord.get(i).equals(child)) {
                    return true;
                }
            }
            return false;
        }

        List<String> allWord = new ArrayList<>();

        void getAllwords(int len, String[] words) {
            dfs(words, new StringBuilder(), len,new boolean[words.length]);
        }

        void dfs(String[] words, StringBuilder sb, int len,boolean[] used) {
            if (sb.length() == len) {
                allWord.add(sb.toString());
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if(!used[i]){
                    used[i] = true;
                    sb.append(words[i]);
                    dfs(words, sb, len,used);
                    sb.delete(sb.length() - words[i].length(), sb.length());
                    used[i] = false;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

