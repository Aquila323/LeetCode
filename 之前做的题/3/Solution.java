
���˸��룺

�����������һ�����ۣ�ԭ��˼·����HashSet��¼�ѱ����ַ������Ѿ����ֹ����ַ���
��������ظ��ֽھ�ֱ��clear��HashSet�еļ�¼��һ���Ծͷ������⣬����ظ��ִ������Ҳ�����

�޸�Ϊsubstring��������¼��ÿ��ѭ�����ִ�Ĳ��ظ��ִ���ʹ��String.indexOf�ж��Ӵ����Ƿ����ظ��ַ����������Ƚ�ֱ�ӣ�������⣬���ڴ����Ľϴ�

��������е����۷�����ʹ��HashMap�ķ�����

�������漰���ظ����������ﶼ���Կ���HashMap�ķ�������Ϊ��HashSet����һ����¼λ�õ�������
�ܽ����������


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
            if (maxSubString == null) { // �״�����ѭ�����Ե�һ���ַ���ʼ��
                curLength = 1;
                maxLength = 1;
                startIndex = 0;
                maxSubString = s.substring(startIndex, endIndex + 1);
                continue;
            }

            if (maxSubString.indexOf(ch) == -1) {   //����µ��ַ�����������ֱ����չsubString
                maxSubString = s.substring(startIndex, endIndex + 1);
                //maxSubString + ch;
                curLength++;
            } else {    //����µ��ַ����������ҵ�ch��subString���״γ��ֵ�λ�ã����¸�ֵ
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

������бȽ�����Ľⷨ��

�������һ����Ϊ�����⣬��ʵ����ȷ�ġ�
����start���ֵʱ��������map���ظ���Ԫ�ر�����start֮��ſ���

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);	// ע�����start�Ǵ��ڿ�ʼ������
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }
}


/******************************************************************

�ҵĴ���ⷨ��
ͨ������������
407 / 987
���룺
"dvdf"
�����
2
Ԥ�ڽ����
3



/*
* ��ҪJava�ִ������ͼ��ϲ���
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