package org.sdrc.childinfo.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sdrc.childinfo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/download")
public class FileDownloadController {

	@Autowired
	ResourceBundleMessageSource workspaceMessageSource;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping(method = RequestMethod.GET)
	public String doDownload(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes){
		
		java.io.InputStream inputStream;
		String referer = request.getHeader(Constants.REFERER);
		referer = referer!= null ? referer : "/";
		try{
			String fileName = ResourceBundle.getBundle("spring/app").getString("offline.adaptation.path");
			System.out.println(fileName);
			inputStream  = new FileInputStream(fileName);
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", new java.io.File(fileName).getName());
			response.setHeader(headerKey, headerValue);
			ServletOutputStream outputStream = response.getOutputStream();
			FileCopyUtils.copy(inputStream, outputStream);
			outputStream.close();
		}
			catch (FileNotFoundException e) {
				List<String> err=new ArrayList<String>();
				err.add(workspaceMessageSource.getMessage(Constants.FILE_NOT_FOUND, null, null));
				redirectAttributes.addFlashAttribute("formError", err);
				redirectAttributes.addFlashAttribute("className", "alert alert-danger");
				return Constants.REDIRECT+referer;
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
		return null;
		
	}
	
}
