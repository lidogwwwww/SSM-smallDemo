package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author dog-king
 * @create 2022/5/19
 */
@Controller
public class FileController {
    @RequestMapping(value = "/fileUp", method = RequestMethod.POST)
    public String fileUp(MultipartFile photo, HttpSession session) {
        String FileName = photo.getOriginalFilename();
        String suffixName = FileName.substring(FileName.lastIndexOf("."));
        String preName = (String) session.getAttribute("loginUser");
        FileName = preName + suffixName;
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String finalPath = photoPath + File.separator + FileName;
        try {
            photo.transferTo(new File(finalPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/account";
    }
}
