package com.hs.controller;

import com.hs.entity.Customer;
import com.hs.entity.Photo;
import com.hs.entity.Photo1;
import com.hs.entity.Xc;
import com.hs.service.CustomerService;
import com.hs.service.PhotoService;
import com.hs.service.XcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private XcService xcService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/photo/upload")
    public String upload(MultipartFile photo,HttpSession session,String xc_name,HttpServletResponse resp) throws IOException {
        String originalFilename = photo.getOriginalFilename();
        String last=originalFilename.substring(originalFilename.indexOf("."),originalFilename.length());
        String uniqueName=originalFilename.replace(last,"") + UUID.randomUUID().toString()+last;
        String location="D:\\photo\\" + uniqueName;
        File file = new File(location);
        photo.transferTo(file);
        Photo1 photo1=new Photo1();
        photo1.setO_name(originalFilename);
        photo1.setU_name(uniqueName);
        photo1.setU_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        String username = (String)session.getAttribute("username");
        Customer customer = customerService.findCustomerByUsername(username);
        photo1.setC_id(customer.getC_id());
        Xc xc = xcService.selectXcByXcname(xc_name);
        if (xcService.selectXcByXcid(xc.getXc_id())==null){ photo1.setXc_id(2);
        }
        photo1.setXc_id(xc.getXc_id());
        int i = photoService.insertPhoto(photo1);
        resp.sendRedirect("/static/customer/photo.html");
        return "upload ok";
    }

    @RequestMapping("photo/deletePhoto")
    public String deletePhoto(int p_id,HttpServletResponse resp) throws IOException {
        Photo photo = photoService.findPhotoByPid(p_id);
        int i = photoService.deletePhoto(p_id);
        String location="D:\\photo\\"+photo.getU_name();
        File file = new File(location);
        file.delete();
        resp.sendRedirect("/static/customer/photo.html");
        return "success";
    }

    @GetMapping("/photo/findAllPhoto")
    public List<Photo> findAllPhoto(HttpSession session, HttpServletResponse resp){
        String username = (String)session.getAttribute("username");
        List<Photo> photos = photoService.findAllPhoto(username);
        Cookie cookie=new Cookie("username",username);
        resp.addCookie(cookie);
        return photos;
    }

    @RequestMapping("/photo/update")
    public String update(){
        int i = photoService.updatePhoto(100, 1);
        return i+"  ";
    }

}
