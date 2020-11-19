package com.o1teck;

import java.io.IOException;
import java.util.Map;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudinary.Cloudinary;
//import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;

@RestController
public class Controller
{
	
    @Autowired
    Cloudinary cloudinary;
    

    @RequestMapping("/")
    public ModelAndView UploadPage(ModelAndView modelAndView) {
    	modelAndView.setViewName("uploadview");
    	return modelAndView;
    }
    	
    	
    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file) throws IOException {
    	
    	System.out.println();
    	System.out.println("Called the uploadFile() method !");
    	System.out.println();
    	
    	String fileName = file.getOriginalFilename();
    	
       
    	Map uploadResult2 = cloudinary.uploader().upload(fileName, ObjectUtils.emptyMap());
        // Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, params);
        
        // Cloudinary cloudinaryConfig = Singleton.getCloudinary();
    	// Map uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, params);
    	
    	//Map uploadResult2 = cloudinary.uploader().upload(new File (fileName), params);
    	//Map uploadResult = cloudinary.uploader().upload(new File("doc.mp4"), params);
    	
    	JSONObject json=new JSONObject(uploadResult2);
        String url=json.getString("url");
    	
    	//String responseString = uploadResult2.toString();
        
        // TEST
    	System.out.println();
    	System.out.println(url);
    	System.out.println();
        
        return url;
    	
    	//Uploads file to Cloudinary, returning a String of its URL
    	//String url = cloudinaryService.uploadFile(file);
    	
    	//  AT THIS POINT THE UPLOAD HAS BEEN ACCOMPLISHED... theoretically.
    	//  Now...
    		// 1) save the url in the DB
    		// 2) pass the url back to the JSP
    		// 3) reload the jsp
    	
    	//	Pass profilePhotoName back to JSP
    	//modelAndView.addObject("profilePhotoName", url);
    	
       // modelAndView.setViewName("redirect:/profile");
    	
       // return responseString;
    	
    	//return user.getProfilePhotoUrl();
    	//return new ResponseEntity(url, HttpStatus.OK);
    }
    
    
   
}
