package com.hs.controller;

import com.hs.entity.Customer;
import com.hs.entity.Photo;
import com.hs.entity.Xc;
import com.hs.service.CustomerService;
import com.hs.service.PhotoService;
import com.hs.service.XcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class XcController {

    @Autowired
    private XcService xcService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/xc/register")
    public String register(Xc xc){
        int i = xcService.register(xc);
        return "register ok";
    }

    @PutMapping("/xc/update")
    public String update(Xc xc){
        int i = xcService.update(xc);
        return "update ok";
    }

    @RequestMapping("/xc/delete")
    public void delete(String xc_id, HttpServletResponse response) throws IOException {
        int i = xcService.delete(xc_id);
        List<Photo> photos = photoService.findPhotoByXc_id(Integer.parseInt(xc_id));
        for (Photo photo : photos) {
            int j = photoService.updatePhoto(photo.getP_id(), 1);
        }
        response.sendRedirect("/static/customer/xc.html");
    }

    @GetMapping("/xc/queryAll")
    public List<Xc> queryAll(HttpSession session){
        String username = (String)session.getAttribute("username");
        List<Xc> xcs = xcService.selectAllXc();
        return xcs;
    }

    @GetMapping("/xc/findXcByXcid")
    public Xc findXcByXcid(int xc_id){
        Xc xc = xcService.selectXcByXcid(xc_id);
        return xc;
    }
}
