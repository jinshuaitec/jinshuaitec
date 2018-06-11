package com.jinstec;

import org.junit.Test;

import java.io.*;

/**
 * @author jins
 * @date on 2018/5/10.
 */
public class FileTest {


    @Test
    public void fileTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(""));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
        int i;
        while ((i = fileInputStream.read()) != -1){
            fileOutputStream.write(i);
        }
    }

    @Test
    public void bufferedInputStream() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("")));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("")));
        int i;
        while ((i=bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(i);
        }
    }
}
