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

	
	//ê¸€ ìž‘ì„±
	@RequestMapping(value = "board/write", method = RequestMethod.GET)
	public void write() {
		
		
	}
	
<<<<<<< HEAD
	//ê¸€ ì¡°íšŒ
	
	//ê¸€ ìˆ˜ì •
	
	//ê¸€ ì‚­ì œ
=======
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public Map fileUpload(HttpServletRequest req, HttpServletResponse rep) { 
        //ÆÄÀÏÀÌ ÀúÀåµÉ path ¼³Á¤ 
        // String path = req.getSession().getServletContext().getRealPath("") + "\\resources";    // À¥ÇÁ·ÎÁ§Æ® °æ·Î À§Ä¡
        String path = "C:\\upload";
        
        System.out.println("path : " + path);
        
        Map returnObject = new HashMap(); 
        try { 
            // MultipartHttpServletRequest »ý¼º 
            MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req; 
            Iterator iter = mhsr.getFileNames(); 
            MultipartFile mfile = null; 
            String fieldName = ""; 
            List resultList = new ArrayList(); 
            
            // µð·¹Åä¸®°¡ ¾ø´Ù¸é »ý¼º 
            File dir = new File(path); 
            if (!dir.isDirectory()) { 
                dir.mkdirs(); 
            } 
            
            // °ªÀÌ ³ª¿Ã¶§±îÁö 
            while (iter.hasNext()) { 
                fieldName = (String) iter.next(); // ³»¿ëÀ» °¡Á®¿Í¼­ 
                mfile = mhsr.getFile(fieldName); 
                String origName; 
                origName = new String(mfile.getOriginalFilename().getBytes("8859_1"), "UTF-8"); //ÇÑ±ÛƒÆÁü ¹æÁö 
                
                System.out.println("origName: " + origName);
                // ÆÄÀÏ¸íÀÌ ¾ø´Ù¸é 
                if ("".equals(origName)) {
                    continue; 
                } 
                
                // ÆÄÀÏ ¸í º¯°æ(uuid·Î ¾ÏÈ£È­) 
//                String ext = origName.substring(origName.lastIndexOf('.')); // È®ÀåÀÚ 
//                String saveFileName = getUuid() + ext;
                String saveFileName = origName;
                
                System.out.println("saveFileName : " + saveFileName);
                
                // ¼³Á¤ÇÑ path¿¡ ÆÄÀÏÀúÀå 
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
    
    //uuid»ý¼º
    public static String getUuid() { 
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


>>>>>>> 0069d611cf3e3cf00dc4208b11e8ced8c7b1e882
	

	
	
}
