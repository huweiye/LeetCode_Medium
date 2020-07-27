package BinaryDivide;

import org.junit.Test;

public class GenerateParenthesisTest {
    @Test
    public void generateParenthesis() throws Exception {
        GenerateParenthesis g=new GenerateParenthesis();
        long startTime=System.currentTimeMillis();   //获取开始时间
        g.generateParenthesis(15);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

        startTime=System.currentTimeMillis();   //获取开始时间
        g.generatePa2(15);
        endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }



}