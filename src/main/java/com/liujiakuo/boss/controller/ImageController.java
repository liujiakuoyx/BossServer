package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.base.http.MessageResponse;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final String IMAGE_FILE_PATH = "/boss/image/";

    /**
     * 上传图片
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public MessageResponse upload(@RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return new MessageResponse(3000,"isEmpty");
        }
        try {
            //文件名取md5，防止重复文件
            String imageName = DigestUtils.md5DigestAsHex(image.getInputStream());
            //原文件名
            String imageOriginalName = image.getOriginalFilename();
            //拓展名
            String suffixName = imageOriginalName.substring(imageOriginalName.indexOf("."));
            //图片储存路径
            String imagePath = IMAGE_FILE_PATH + imageName + suffixName;
            File dest = new File(imagePath);
            //检测文件夹是否存在
            if (!dest.getParentFile().exists()) {
                System.out.println("mk paren dir");
                dest.getParentFile().mkdir();
            }
            if (!dest.exists()) {
                //储存文件
                image.transferTo(dest);
                System.out.println("save image");
            } else {
                System.out.println("md5 equals,image exists");
            }
            return new MessageResponse(200,"success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MessageResponse(3000,"error");
    }

    /**
     * 获取图片
     */
    @RequestMapping(value = "/{name}")
    public void getImage(@PathVariable("name") String imageName, HttpServletResponse response) {
        if (DataUtils.isEmpty(imageName)) {
            return;
        }
        String imagePath = IMAGE_FILE_PATH + imageName;
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + imageName);// 设置文件名
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(imagePath);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DataUtils.closeStream(bis);
            DataUtils.closeStream(fis);
        }
    }
}
