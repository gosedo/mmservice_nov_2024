package com.mmsystem.property.util;

public class MmsComposeEmailUtil {
	
	public static EmailDetails composerNewAccountEmail( String email, String verificationId) {
		
		String emailBody = String.format("Dear, Mmservice Account has been create for you. "
				+ "Plsease use the following link to verify and you password."
				+ "http://localhost:4200/newuser/activation?id=%s", verificationId);
		
		
		EmailDetails emailDetail = new EmailDetails();
		emailDetail.setRecipient(email);
		emailDetail.setSubject("New Mmsservice Account");
		emailDetail.setMsgBody(emailBody);
		
		
		return emailDetail;
	}

}
