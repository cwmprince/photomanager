package com.hs.controller;

import com.hs.entity.Photo;
import com.hs.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class findPhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/photo/findPhoto")
    public void findPhoto(int p_id, HttpServletResponse resp) throws IOException {
        Photo photo = photoService.findPhotoByPid(p_id);
        String u_name = photo.getU_name();
        resp.sendRedirect("/photo1/"+u_name);
    }

}
