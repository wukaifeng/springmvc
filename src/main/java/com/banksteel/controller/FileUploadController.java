package com.banksteel.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传
 */
@Controller
public class FileUploadController {

    /*
     * 通过流的方式上传文件
     * 
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("fileUpload1")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        // 用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());

        try {
            // 获取输出流
            OutputStream os = new FileOutputStream("D:/" + new Date().getTime() + file.getOriginalFilename());
            // 获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is = file.getInputStream();
            int temp;
            // 一个一个字节的读取并写入
            while ((temp = is.read()) != (-1)) {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "success";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("fileUpload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        String path = "D:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "/success";
    }

    @RequestMapping("springUpload3")
    public String springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        // 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver =
            new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            // 将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = "D:/springUpload" + file.getOriginalFilename();
                    // 上传
                    file.transferTo(new File(path));
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "success";
    }

    @RequestMapping("/dUploadFile")
    // 用 MultipartFile[]  来接受上传的多个文件
    public String duoFilesLoade(
        @RequestParam("dUploadFile") MultipartFile[] files, HttpServletRequest request) {
        try {
            File dir = new File("D:" + File.separatorChar + "temp" + File.separatorChar );
            if (!dir.exists()) {
                dir.mkdirs();
            }
            boolean flag = true;
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String filename = file.getOriginalFilename();
                if (filename != null && !"".equals(filename.trim())) {
                    flag = false;
                    if (filename.endsWith("jpg") || filename.endsWith(".doc") || filename.endsWith(".docx")) {
                        System.out.println(dir.getAbsolutePath());
                        File mbfile = new File(dir.getAbsolutePath() + File.separatorChar + filename);
                        // 将 file 复制给 mbfile
                        file.transferTo(mbfile);
                    } else {
                        request.setAttribute("filename", file.getOriginalFilename());
                        request.setAttribute("message1", "文件必须以 jpg或doc或docx开头");
                        return "fileNull";
                    }
                }

            }
            // 如果一个文件也没有上传
            if (flag) {
                return "fileNull";
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
