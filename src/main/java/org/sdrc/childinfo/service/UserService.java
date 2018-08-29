package org.sdrc.childinfo.service;

import org.sdrc.childinfo.model.Mail;

public interface UserService {
	
	String sendMail(Mail mail) throws Exception;

	String sendMail(String fromUserName, String toUserName, String toEmailId,StringBuffer subject, StringBuffer msg) ;
	
	String sendAdaptionMail(Mail mail) throws Exception;
}
