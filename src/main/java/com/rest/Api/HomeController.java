package com.rest.Api;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@ModelAttribute FileInfo fileinfo, Model model) throws IllegalStateException, IOException {
	System.out.println(fileinfo.getFile().getOriginalFilename()+"***");


	File file= new File("/media/New Volume/UploadImage/"+fileinfo.getFile().getOriginalFilename());

	// FileWriter fileWriter = new FileWriter(file+""+fileinfo.getFile().getOriginalFilename());

	MultipartFile multiPartFile = fileinfo.getFile();
	multiPartFile.transferTo(file);

	    /*FileOutputStream fout = new FileOutputStream(file);
	    fout*/

	return "home";
	}
	
	
}
