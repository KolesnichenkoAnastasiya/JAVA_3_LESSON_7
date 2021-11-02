package com.company;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class Arr {
        private static int lastNumber = 4;
        private static int containsNumber1 = 1;
        private static int containsNumber2 = 4;
        public static void main(String[] args) {
        }
        public static final int[] arrayAfterLastNumber (int[] arr){
            if (arr.length != 0) {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (arr[i] == lastNumber) {
                        return Arrays.copyOfRange(arr, i+1, arr.length);
                    }
                }
            }
            throw new RuntimeException("Массив должен содержать минимум 1 четверку");
        }
        public static boolean onlyOneOrFour(int[] arr) {
            int counterNumber1 =0;
            int counterNumber2 =0;
            for (int i : arr) {
                if (i == containsNumber1 ) { counterNumber1++;
                }
                if (i == containsNumber2) { counterNumber2++;
                }
                else if(i!=containsNumber1 && i!=containsNumber2){
                    return false;
                }
            }
            if (counterNumber1>0 && counterNumber2>0) {
                return true;
            }
            else return false;
        }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface AfterSuite {
}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface BeforeSuite {
    }
}
