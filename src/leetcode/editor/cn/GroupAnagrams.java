//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1330 👎 0

package leetcode.editor.cn;

import java.util.*;

//java:字母异位词分组
public class GroupAnagrams{
    public static void main(String[] args){
        Solution solution = new GroupAnagrams().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        //将每个字符排序后,作为key,存储在hashmap
        HashMap<String,List> hashMap = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            List<String> strings = hashMap.getOrDefault(key, new ArrayList<String>());
            strings.add(str);
            hashMap.put(key,strings);
        }

        for(String key : hashMap.keySet()){
            res.add(hashMap.get(key));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

