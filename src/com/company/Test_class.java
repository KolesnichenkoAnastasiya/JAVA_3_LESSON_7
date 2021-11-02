package com.company;

import static com.company.Arr.arrayAfterLastNumber;
import static com.company.Arr.onlyOneOrFour;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class Test_class {
    @Arr.BeforeSuite
    public void bs(){
        System.out.println("Before test. @BeforeSuite");
    }
    @Test(priority = 1)
    public void TestArrayAfterLastNumber1 (){
        int [] in = {5, 15, 8, 4, 99};
        int [] out ={99};
        assertArrayEquals(out, arrayAfterLastNumber(in));
        System.out.println("TestArrayAfterLastNumber1 @Test priority =1");
    }
    @Test(priority = 2)
    public void TestArrayAfterLastNumber2 (){
        int [] in = {5, 15, 8, 4, 99, 15, 12};
        int [] out ={99, 15, 12};
        assertArrayEquals(out, arrayAfterLastNumber(in));
        System.out.println("TestArrayAfterLastNumber2 @Test priority =2");
    }
    @Test(priority = 3)
    public void TestArrayAfterLastNumber3 (){
        int [] in = {5, 15, 8, 1, 99};
        assertThrows(RuntimeException.class,()->{arrayAfterLastNumber(in);});
        System.out.println("TestArrayAfterLastNumber3 @Test priority =3");
    }
    @Test(priority = 4)
    public void TestArrayAfterLastNumber4 (){
        int [] in = {5, 15, 8, 4};
        int [] out ={};
        assertArrayEquals(out, arrayAfterLastNumber(in));
        System.out.println("TestArrayAfterLastNumber4 @Test priority =4");
    }
    @Test(priority = 5)
    public void TestOnlyOneOrFour1 (){
        int [] in = {1, 1, 1, 1, 1};
        assertFalse(onlyOneOrFour(in));
        System.out.println("TestOnlyOneOrFour1 @Test priority =5");
    }
    @Test(priority = 2)
    public void TestOnlyOneOrFour2 (){
        int [] in = {1, 1, 1, 4, 1};
        assertTrue(onlyOneOrFour(in));
        System.out.println("TestOnlyOneOrFour2 @Test priority =2");
    }
    @Test()
    public void TestOnlyOneOrFour3 (){
        int [] in5 = {1, 4, 1, 12, 1};
        assertFalse(onlyOneOrFour(in5));System.out.println("TestOnlyOneOrFour3 @Test without priority ");
    }
    @Arr.AfterSuite
    public void afs(){
        System.out.println("After test. @AfterSuite");
    }
}
