package com.leshuibao.fragmentTax.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class FileUtil {

    public static void rename(String path, String oldFileName, String newFileName) {
        File oldFile = new File(path + oldFileName);
        File newFile = new File(path + newFileName);
        if(!oldFile.exists()){
            return;//重命名文件不存在
        }
        if(newFile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            System.out.println(newFile+"已经存在！");
        else{
            oldFile.renameTo(newFile);
        }

    }

    public static void main(String[] args) {
        File oldeFile = new File("D:\\data_yang\\pro_leshuibao\\leshuibao_v2\\fragmentTax-1101\\src\\main\\resources\\icimg\\test4@1100004444—1.jpg");
        File newFile = new File("D:\\111.jpg");
        oldeFile.renameTo(newFile);
        return;
    }
}
