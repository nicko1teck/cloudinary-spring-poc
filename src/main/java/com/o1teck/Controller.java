package com.o1teck;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file) throws IOException, URISyntaxException {
    	
    	System.out.println();
    	System.out.println("Called the uploadFile() method !");
    	System.out.println();
    	
    	//set upload params
    	Map params = ObjectUtils.asMap(
    			"cloud_name", "nicko1teck",
    		    "public_id", "my_folder/my_sub_folder/"+file.getOriginalFilename(),
    		    //overwrite", true,
    		   // "notification_url", "https://mysite/notify_endpoint",
    		    "resource_type", "auto");
    	
    	//Create path to file's location on server
    	// Path filepath = Paths.get("C:\\Users\\Owner\\Desktop\\test_cloudinary_directory\\", file.getOriginalFilename());    			
    	
    	//write incoming file's bytes to this new file on the server
    	// try (OutputStream os = Files.newOutputStream(filepath)) {
    	//	   os.write(file.getBytes());
    	//	}
    	
    	//point new file object at the file-on-server
    	//File tempImageFile = new File(filepath.toString());
    	
    	//upload the file
    	Map uploadResult3 = cloudinary.uploader().unsignedUpload(file.getBytes(), "apzbavjn", params);
    	    	
        //return url;
    	return uploadResult3.toString();
    	
  
    }
    
    
   
}
