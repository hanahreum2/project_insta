package com.mvc.insta.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "board/write", method = RequestMethod.GET)
	public void write() {
		
		
	}
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Map fileUpload(HttpServletRequest req, HttpServletResponse rep) { 
        //파일이 저장될 path 설정 
        // String path = req.getSession().getServletContext().getRealPath("") + "\\resources";    // 웹프로젝트 경로 위치
        String path = "C:\\upload";
        
        System.out.println("path : " + path);
        
        Map returnObject = new HashMap(); 
        try { 
            // MultipartHttpServletRequest 생성 
            MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req; 
            Iterator iter = mhsr.getFileNames(); 
            MultipartFile mfile = null; 
            String fieldName = ""; 
            List resultList = new ArrayList(); 
            
            // 디레토리가 없다면 생성 
            File dir = new File(path); 
            if (!dir.isDirectory()) { 
                dir.mkdirs(); 
            } 
            
            // 값이 나올때까지 
            while (iter.hasNext()) { 
                fieldName = (String) iter.next(); // 내용을 가져와서 
                mfile = mhsr.getFile(fieldName); 
                String origName; 
                origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //한글꺠짐 방지 
                
                System.out.println("origName: " + origName);
                // 파일명이 없다면 
                if ("".equals(origName)) {
                    continue; 
                } 
                
                // 파일 명 변경(uuid로 암호화) 
//                String ext = origName.substring(origName.lastIndexOf('.')); // 확장자 
//                String saveFileName = getUuid() + ext;
                String saveFileName = origName;
                
                System.out.println("saveFileName : " + saveFileName);
                
                // 설정한 path에 파일저장 
                File serverFile = new File(path + File.separator + saveFileName);
                mfile.transferTo(serverFile);
                
                Map file = new HashMap();
                file.put("origName", origName); file.put("sfile", serverFile);
                resultList.add(file);
            }
            
            returnObject.put("files", resultList); 
            returnObject.put("params", mhsr.getParameterMap()); 
            } catch (UnsupportedEncodingException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            }catch (IllegalStateException e) { // TODO Auto-generated catch block 
                e.printStackTrace();
            } catch (IOException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
            return null;
    }
    
    //uuid생성
    public static String getUuid() { 
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


	

	
	
}
