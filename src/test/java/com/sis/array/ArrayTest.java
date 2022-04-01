package com.sis.array;

import java.util.Arrays;

/**
 * @ClassName: ArrayTest
 * @Description: TODO
 * @Author: Sissi
 * @Date: 2022/4/1 15:38
 * @Version: 1.0
 */
public class ArrayTest {

    public static void main(String[] args) {
        // NOTICE 1.声明数组、创建数组
        byte[] byteArray;
        short shortArray[];// C++声明方式，不建议使用
        int[] intArray = {};
        long[] longArray = new long[2];
        float[] floatArray = {1f, 2f};
        double[] doubleArray = new double[]{3d, 4d};

        /*System.out.println(byteArray);
        System.out.println(shortArray);*/
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(longArray));
        System.out.println(Arrays.toString(floatArray));
        System.out.println(Arrays.toString(doubleArray));

        // NOTICE 2.增删改查时间空间复杂度


    }


}

// NOTICE: 值传递，引用传递
// Java基本数据类型传递参数时是值传递，引用类型传递参数时是引用传递。
// 然而数组虽然是引用传递，
// 但是将引用 z = null 只是将引用z不指向任何对象，并不会对原先指向的对象数据进行修改。
class TestIt1 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        ChangeIt.doIt(myArray);
        for (int j = 0; j < myArray.length; j++)
            System.out.print(myArray[j] + " ");
    }
}

class ChangeIt {
    static void doIt(int[] z) {
        z = null;
    }
}

// NOTICE: 数组作为参数是引用传递，在doIt方法中可以修改数组的值。
class LowHighSwap {
    static void doIt(int[] z) {
        int temp = z[z.length - 1];
        z[z.length - 1] = z[0];
        z[0] = temp;
    }
}

class TestIt2 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        LowHighSwap.doIt(myArray);
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
    }
}
