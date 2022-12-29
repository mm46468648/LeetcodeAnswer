//设计一个 map ，满足以下几点: 
//
// 
// 字符串表示键，整数表示值 
// 返回具有前缀等于给定字符串的键的值的总和 
// 
//
// 实现一个 MapSum 类： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // 返回 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // 返回 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 223 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//java:键值映射
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum mapSum = new MapSumPairs().new MapSum();
        mapSum.insert("apple", 3);
        mapSum.sum("ap");           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        mapSum.sum("ap");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class MapSum {

        Node root;

        class Node {
            int val;
            HashMap<Character, Node> next;

            Node() {
                this.val = 0;
                next = new HashMap<>();
            }
        }

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                Node node = cur.next.get(c);
                if (node == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }

            cur.val = val;
        }

        // 设计一个递归函数去完成它
        public int sum(String prefix) {
            Node curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                Character c = prefix.charAt(i);
                if (curNode.next.containsKey(c)) {
                    curNode = curNode.next.get(c);
                } else {
                    return 0;
                }
            }
            return sum(curNode);
        }

        // 计算以 node 为根节点的所有 value 值的和
        private int sum(Node node) {
            int res = node.val;
            for (Character key : node.next.keySet()) {
                // 一直找到根节点
                res += sum(node.next.get(key));
            }
            return res;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

