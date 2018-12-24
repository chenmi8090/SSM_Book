package com.baizhi.util;

import java.util.Random;

/**
 * 这个工具类用来获得随机的验证码
 * 位数以Controllr层设置
 */
public class RandomCode {

    public static String getCode(int n) {

        String code = RandomCode.makeCode(n);

        return code;
    }

    //可以用可变长参数StringBuffer来完成字符串连接,或者直接用String拼接
    public static String makeCode(int n){
        String[] a = {"1","2","3","4","5","6","7","8","9","0"};
        StringBuffer code = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int ran = random.nextInt(10);
            code.append(a[ran]);
        }
        return code.toString();
    }

}
