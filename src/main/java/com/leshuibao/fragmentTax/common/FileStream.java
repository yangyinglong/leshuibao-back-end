package com.leshuibao.fragmentTax.common;

import javax.ws.rs.WebApplicationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileStream {

    private String filePath;

    public FileStream(String filePath) {
        this.filePath = filePath;
    }

    public void write(OutputStream output) throws IOException, WebApplicationException {
        File file = new File(filePath);

        //如果文件不存在，提示404
        if (!file.exists()) {
            throw new WebApplicationException(404);
        }
        output = new FileOutputStream(file);
        output.flush();
        output.close();
    }
}
