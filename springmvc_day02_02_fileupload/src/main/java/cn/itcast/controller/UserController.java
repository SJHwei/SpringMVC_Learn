package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author ShiWei
 * @date 2021/4/20 - 23:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 跨服务器文件上传
     *
     * @return
     */
    @RequestMapping("/fileupload3")
    //注意：下面这个方法的其中一个参数的名字upload必须和表单文件选项的名字(name)一模一样
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");

        //定义上传文件服务器路径
        //path是服务器的请求地址
        //再加一个uploads/，因为一会儿是往uploads文件夹中传入文件
        String path = "http://localhost:7070/fileuploadserver_war_exploded/uploads/";


        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;


        //完成文件上传，跨服务器上传

        //如果想要实现跨服务器上传，必须用到一组新的API，导入资料中的jar包即可
        //jar包有了，就可以写一些方法来实现跨服务器上传

        //1.创建客户端的对象
        Client client = Client.create();
        //2.和图片服务器进行连接
        //注意：这儿有一个小技巧
        //正常的path最后有一个/，如果path最后不写斜杠，那下面代码就要拼接/，如果path最后写了斜杠，则使用下面代码即可，不用拼接/。
        WebResource webResource = client.resource(path + fileName);
        //3.上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

    /**
     * SpringMVC文件上传
     *
     * @return
     */
    @RequestMapping("/fileupload2")
    //注意：下面这个方法的其中一个参数的名字upload必须和表单文件选项的名字(name)一模一样
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");

        //使用fileupload组件完成文件上传

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件上传
        upload.transferTo(new File(path, fileName));

        return "success";
    }

    /**
     * 文件上传
     *
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");

        //使用fileupload组件完成文件上传

        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明是普通表单
            } else {
                //说明是上传文件项
                //获取上传文件的名称
                String fileName = item.getName();
                //把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件
                item.delete();
            }
        }

        return "success";
    }
}
