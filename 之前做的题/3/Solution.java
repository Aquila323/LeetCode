
个人感想：

这个题我做的一波三折，原本思路是用HashSet记录已遍历字符串中已经出现过的字符，
如果遇到重复字节就直接clear掉HashSet中的记录，一测试就发现问题，误把重复字串后面的也清掉了

修改为substring方法，记录下每次循环后现存的不重复字串，使用String.indexOf判断子串中是否有重复字符。这样做比较直接，易于理解，但内存消耗较大。

看了题解中的评论发现了使用HashMap的方法。

可能在涉及“重复”的问题里都可以考虑HashMap的方法，因为比HashSet多了一个记录位置的能力，
能解决更多问题


/******************************************************************
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curLength = 0;
        int maxLength = 0;

        int startIndex = 0;
        String maxSubString = null;
        int stringLength = s.length();
        for (int endIndex = 0; endIndex < stringLength; endIndex++) {
            char ch = s.charAt(endIndex);
            if (maxSubString == null) { // 首次运行循环，以第一个字符初始化
                curLength = 1;
                maxLength = 1;
                startIndex = 0;
                maxSubString = s.substring(startIndex, endIndex + 1);
                continue;
            }

            if (maxSubString.indexOf(ch) == -1) {   //如果新的字符不包含，则直接扩展subString
                maxSubString = s.substring(startIndex, endIndex + 1);
                //maxSubString + ch;
                curLength++;
            } else {    //如果新的字符包含，则找到ch在subString中首次出现的位置，重新赋值
                int index = maxSubString.indexOf(ch);
                startIndex += (index + 1);
                maxSubString = s.substring(startIndex, endIndex + 1);
                curLength = maxSubString.length();
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }
}

/******************************************************************

解题答案中比较优秀的解法：

这个答案我一度以为有问题，其实是正确的。
更新start这个值时，考虑了map中重复的元素必须在start之后才可以

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);	// 注意这里，start是窗口开始的坐标
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}


/******************************************************************

我的错误解法：
通过测试用例：
407 / 987
输入：
"dvdf"
输出：
2
预期结果：
3



/*
* 需要Java字串操作和集合操作
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curLength = 0;
        int maxLength = 0;
        HashSet hashSet = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashSet.contains(ch)) {
                hashSet.clear();
                hashSet.add(ch);
                curLength = 1;
            } else {
                hashSet.add(ch);
                curLength++;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }
}