package com.leshuibao.fragmentTax.controller.endpoint;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.leshuibao.fragmentTax.common.FileStream;
import com.leshuibao.fragmentTax.logicalModel.IAuthorizeLogical;
import com.leshuibao.fragmentTax.util.PropertiesUtil;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/suppliment")
@CrossOrigin
public class SupplementController {

    private static final String IMAGE_PATH = PropertiesUtil.prop("img_path");
    private static final String FILE_PATH = PropertiesUtil.prop("file_path");
    private static final String QR_PATH = PropertiesUtil.prop("qr_code_path");

    @Autowired
    private IAuthorizeLogical authorizeLogical;

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    public void upload(@FormDataParam("file") InputStream fileInputStream,
                       @FormDataParam("file") FormDataContentDisposition fileDisposition,
                       @FormDataParam("fileName") String fileName,
                       @FormDataParam("isFront") String isFront) throws IOException {

        fileName = fileName + "—" + isFront + ".jpg";

        //使用common io的文件写入操作
        FileUtils.copyInputStreamToFile(fileInputStream, new File(IMAGE_PATH + fileName));
    }

    /**
     * 前端请求图片，加随机数的原因是 修改开票人的时候，重新上传图片，如果是同样的请求参数，加载的是页面缓存，而不是重新请求服务器
     * @param payeeId
     * @param payeeName
     * @param isFront
     * @param randomDouble
     * @return
     */
    @GET
//    @Consumes(MediaType.APPLICATION_OCTETd_STREAM)
    @Path("/printIC")
    public Response printIC(@QueryParam("payeeId") String payeeId, @QueryParam("payeeName") String payeeName, @QueryParam("isFront") String isFront, @QueryParam("randomInt") double randomDouble) {
        String fileName = payeeName + "@" + payeeId + "—" + isFront + ".jpg";
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get(IMAGE_PATH + fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename =" + fileName)
                .build();
    }


    @GET
    @Path("/printQrImg")
    public Response printQrImg(@QueryParam("orderId") String orderId) {
        String fileName = orderId + ".jpg";
        StreamingOutput fileStream = new StreamingOutput() {
            @Override
            public void write(java.io.OutputStream output) throws WebApplicationException {
                try {
                    java.nio.file.Path path = Paths.get(QR_PATH + fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                } catch (Exception e) {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename =" + fileName)
                .build();
    }

    /**
     *
     * 打印Excel
     *
     * @param orderId
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/printOrder")
    public Response printOrder(@QueryParam("orderId") String orderId) throws IOException {

        // 根据payeeId找到身份证正反面图片地址，然后跟download一样
        // filePath gen
        String fileName = orderId + ".xlsx";

        System.out.println(FILE_PATH + fileName); // 这个可能出bug

        authorizeLogical.genExcel(FILE_PATH, fileName, orderId);

        File file = new File(FILE_PATH + fileName);
        //如果文件不存在，提示404
        if (!file.exists()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        return Response
                .ok(file)
                .header("Content-disposition", "attachment;filename=" + fileName).build();
    }

    /**
     * todo
     * 打印快递单
     *
     * @param expressCompany, address
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/printExpress")
    public Response printExpress(@QueryParam("expressCompany") String expressCompany, @QueryParam("address") String address) {

        return null;
    }

}