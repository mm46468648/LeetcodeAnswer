//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 473 👎 0

package leetcode.editor.cn;
//java:添加与搜索单词 - 数据结构设计
public class DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args){
//        Solution solution = new DesignAddAndSearchWordsDataStructure().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

        Node root;

        class Node{
            Node[] next;
            boolean isWord;

            public Node(){
                this.next = new Node[26];
                this.isWord = false;
            }

        }
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = current.next[c - 'a'];
            if(node == null){
                current.next[c - 'a'] = new Node();
            }
            current = current.next[c - 'a'];
        }

        if(!current.isWord){
            current.isWord = true;
        }
    }
    
    public boolean search(String word) {
        return match(word,root,0);
    }

        private boolean match(String word, Node node, int i) {
            if(i == word.length()){
                return node.isWord;
            }

            char c = word.charAt(i);
            if(c == '.'){
                for (int j = 0; j < 26; j++) {
                    if(node.next[j]!=null && match(word,node.next[j], i+1)){
                        return true;
                    }
                }
                return false;
            }else {
                if(node.next[c-'a'] == null){
                    return false;
                }
                return match(word,node.next[c-'a'],i+1);
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

