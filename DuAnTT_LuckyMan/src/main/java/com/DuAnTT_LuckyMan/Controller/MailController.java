//package com.DuAnTT_LuckyMan.Controller;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//import javax.mail.MessagingException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.DuAnTT_LuckyMan.dao.AccountDAO;
//import com.DuAnTT_LuckyMan.entity.Account;
//import com.DuAnTT_LuckyMan.service.MailService;
//
//
//@Controller
//public class MailController {
//	
//	@Autowired
//	MailService mail;
//	
//	@Autowired
//	AccountDAO accountDAO ;
//	
//	@RequestMapping("quenmatkhau")
//	public String sb(@RequestParam("username") String username, @RequestParam("email") String email) throws MessagingException {
//		int pass = ThreadLocalRandom.current().nextInt(1000, 9999);
//
//		Account user = accountDAO.findById(username).get();
//		if (username.equals(user.getUsername())) {
//			if (email.equals(user.getEmail())) {
//				user.setPassword(pass + "");
//				accountDAO.save(user);
//				String to = email;
//				String sj = "Thay đổi mật khẩu";
//				String body = "<body style=\"background-color: #85a4cd; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #85a4cd;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-1\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f6fe;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000;\" width=\"650\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<th class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 15px; padding-bottom: 15px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\r\n"
//						+ "<div align=\"center\" style=\"line-height:10px\"><img alt=\"\" src=\"images/YourLogo.png\" style=\"display: block; height: auto; border: 0; width: 140px; max-width: 100%;\" title=\"LUCKY MAN SHOP\" width=\"140\"/></div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</th>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000;\" width=\"650\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<th class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"heading_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:10px;text-align:center;width:100%;padding-top:60px;\">\r\n"
//						+ "<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: 'Roboto Slab', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 30px; font-weight: normal; letter-spacing: 2px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>FORGOT YOUR PASSWORD?</strong></h1>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"width:100%;padding-right:0px;padding-left:0px;\">\r\n"
//						+ "<div align=\"center\" style=\"line-height:10px\"><img alt=\"Wrong Password Animation\" src=\"images/GIF_password.gif\" style=\"display: block; height: auto; border: 0; width: 500px; max-width: 100%;\" title=\"Wrong Password Animation\" width=\"500\"/></div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:25px;\">\r\n"
//						+ "<div style=\"font-family: sans-serif\">\r\n"
//						+ "<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\r\n"
//						+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:20px;\">Don't worry, be happy!</span></p>\r\n"
//						+ "</div>\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:5px;\">\r\n"
//						+ "<div style=\"font-family: sans-serif\">\r\n"
//						+ "<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\r\n"
//						+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:22px;\">Your new password is.</span></p>\r\n"
//						+ "</div>\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"button_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:30px;text-align:center;\">\r\n"
//						+ "<div align=\"center\">\r\n"
//						+ "<input + pass height=\"300px\" width=\"150px\">\r\n"
//						+ "<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:40px;padding-left:10px;padding-right:10px;padding-top:30px;\">\r\n"
//						+ "<div style=\"font-family: sans-serif\">\r\n"
//						+ "<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\r\n"
//						+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:14px;\">If you didn’t request to change your password, simply ignore this email.</span></p>\r\n"
//						+ "</div>\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</th>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-3\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #c4d6ec;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000;\" width=\"650\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<th class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 20px; padding-bottom: 20px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<div style=\"font-family: sans-serif\">\r\n"
//						+ "<div style=\"font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\r\n"
//						+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:12px;\">This link will expire in 24 hours. If you continue to have problems</span><br/><span style=\"font-size:12px;\">please feel free to contact us at <a href=\"mailto:example@example.com\" rel=\"noopener\" style=\"text-decoration: underline; color: #ffffff;\" target=\"_blank\" title=\"support@youremail.com\">support@youremail.com</a>. <a href=\"https://www.example.com\" rel=\"noopener\" style=\"text-decoration: underline; color: #ffffff;\" target=\"_blank\">UNSUBSCRIBE</a></span></p>\r\n"
//						+ "</div>\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</th>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-4\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f6fe;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000;\" width=\"650\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<th class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:50px;text-align:center;\">\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"social-table\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"208px\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img alt=\"Facebook\" height=\"32\" src=\"images/facebook2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"facebook\" width=\"32\"/></a></td>\r\n"
//						+ "<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img alt=\"Twitter\" height=\"32\" src=\"images/twitter2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"twitter\" width=\"32\"/></a></td>\r\n"
//						+ "<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img alt=\"Linkedin\" height=\"32\" src=\"images/linkedin2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"linkedin\" width=\"32\"/></a></td>\r\n"
//						+ "<td style=\"padding:0 10px 0 10px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img alt=\"Instagram\" height=\"32\" src=\"images/instagram2x.png\" style=\"display: block; height: auto; border: 0;\" title=\"instagram\" width=\"32\"/></a></td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:10px;\">\r\n"
//						+ "<div style=\"font-family: sans-serif\">\r\n"
//						+ "<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #7999ac; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;\">\r\n"
//						+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:12px;\">Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Cras mattis consectetur purus sit amet fermentum. Vestibulum id ligula porta felis euismod semper. Curabitur blandit tempus porttitor. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</span></p>\r\n"
//						+ "</div>\r\n"
//						+ "</div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"image_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"padding-bottom:40px;padding-left:20px;padding-right:20px;padding-top:10px;width:100%;\">\r\n"
//						+ "<div align=\"center\" style=\"line-height:10px\"><img alt=\"Your Logo\" src=\"images/YourLogo.png\" style=\"display: block; height: auto; border: 0; width: 130px; max-width: 100%;\" title=\"Your Logo\" width=\"130\"/></div>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</th>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-5\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<td>\r\n"
//						+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000;\" width=\"650\">\r\n"
//						+ "<tbody>\r\n"
//						+ "<tr>\r\n"
//						+ "<th class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
//						+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"icons_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"color:#9d9d9d;font-family:inherit;font-size:15px;padding-bottom:5px;padding-top:5px;text-align:center;\">\r\n"
//						+ "<table cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"text-align:center;\">\r\n"
//						+ "<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\r\n"
//						+ "<!--[if !vml]><!-->\r\n"
//						+ "<table cellpadding=\"0\" cellspacing=\"0\" class=\"icons-inner\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\">\r\n"
//						+ "<!--<![endif]-->\r\n"
//						+ "<tr>\r\n"
//						+ "<td style=\"text-align:center;padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:6px;\"><a href=\"https://www.designedwithbee.com/\"><img align=\"center\" alt=\"Designed with BEE\" class=\"icon\" height=\"32\" src=\"images/bee.png\" style=\"display: block; height: auto; border: 0;\" width=\"34\"/></a></td>\r\n"
//						+ "<td style=\"font-family:Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;font-size:15px;color:#9d9d9d;vertical-align:middle;letter-spacing:undefined;text-align:center;\"><a href=\"https://www.designedwithbee.com/\" style=\"color:#9d9d9d;text-decoration:none;\">Designed with BEE</a></td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</table>\r\n"
//						+ "</th>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table>\r\n"
//						+ "</td>\r\n"
//						+ "</tr>\r\n"
//						+ "</tbody>\r\n"
//						+ "</table><!-- End -->\r\n"
//						+ "</body>" ;
//
//				mail.send(to, sj, body);
//				System.err.println("Mật khẩu mới đã được thay đổi " +pass);
//			}
//		} else {
//			System.err.println("Sai email!!!");
//			return "redirect:/tk/quenmatkhau";
//		}
//		return "redirect:/login";
//	}
//}
