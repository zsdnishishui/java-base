package 基础.IO;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String filename = "src/main/java/基础/IO/demo.txt";
        System.out.println(new File(".").getAbsolutePath());
        InputStream fis = new FileInputStream(filename);
        // fis.read()一次读一个字节，如果没有的话返回-1
        // fis.available() 预估还有多少字节可读，没有的话返回0
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.available());
        fis.close();
        InputStream fisByte = new FileInputStream(filename);
        byte[] bytes = new byte[5];
        // fisByte.read()一次读一个字节数组
        fisByte.read(bytes);
        System.out.println(bytes);
        fisByte.close();
        // BufferedInputStream效率高一些，感觉就像一次读一个字节数组
        InputStream ins = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(ins);
        bis.mark(1); // mark与reset是一对
        System.out.println(bis.read());
        System.out.println(bis.available());
        System.out.println(bis.read());
        System.out.println(bis.read());
        bis.reset();
        System.out.println(bis.read());
        ins.close();
        bis.close();
    }
}
