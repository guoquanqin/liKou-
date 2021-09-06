package com.example.demo.likou;

/**
 * TODO 添加类的描述
 *
 * @author gqq
 * @version 1.0, 2021/7/8 10:29
 */
public class Question38 {

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        return calcuCountAndSay(1,n,"1");
    }

    private String calcuCountAndSay(int index, int n, String count) {
        while(index<n){
            index ++;
            count = generateCount(count);
        }
        return count;
    }

    /**
     * ++i第一步是把自身i+1后才赋值给自身，即先加后赋值。
     *
     * i++第一步是先把自身赋值给自身，即先赋值后再加减。
     *
     * 　　i++也可以这样表示：i = i+1或 i += 1
     * @param count
     * @return
     */
    private String generateCount(String count) {
        char[] chars = count.toCharArray();
        // 统计数量
        int c = 0;
        // 字符
        Character ch = '0';
        StringBuffer result = new StringBuffer();
        for (int i = 0;i<chars.length;i++){
            if(c == 0){
                if(i == chars.length -1){
                    result.append(1).append(chars[i]);
                }else {
                    ch = chars[i];
                    c++;
                }
            }else {
                if(ch == chars[i]){
                    if(i == chars.length -1){
                        result.append(++c).append(chars[i]);
                    }else {
                        c ++;
                    }
                }else {
                    if(i == chars.length -1){
                        result.append(c).append(ch).append(1).append(chars[i]);
                    }else {
                        result.append(String.valueOf(c)).append(String.valueOf(ch));
                        c =1;
                        ch = chars[i];
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Question38 question38 = new Question38();
        System.out.println(question38.countAndSay(1));
        System.out.println(question38.countAndSay(2));
        System.out.println(question38.countAndSay(3));
        System.out.println(question38.countAndSay(4));
    }

}
