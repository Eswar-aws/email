package com.india.Spring;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
//@RequestMapping("/send")
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/home")
	public String hom()
	{
		return "EmailForm";
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String sendTo(HttpServletRequest req,final @RequestParam CommonsMultipartFile attachFile)
	{
		String rece=req.getParameter("recepient");
		String sub=req.getParameter("subject");
		String mess=req.getParameter("message");
		
		javaMailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception
			{
				MimeMessageHelper mimeHelper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
				mimeHelper.setTo(rece);
				mimeHelper.setSubject(sub);
				mimeHelper.setText(mess);
				String attachName=attachFile.getOriginalFilename();
				
				if(!attachName.equals(""))
				{
					mimeHelper.addAttachment(attachName,new InputStreamSource() {
					@Override
					public InputStream getInputStream() throws IOException
					{
						return attachFile.getInputStream();
					}
					});
				}
			}	
		});		
		return "Result";
	}
}
