package chart;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailCode {
private static String luutru_teencode;
	
    public static void guiTeenCodequa_gmail(String toEmail) {
        // Cấu hình thông tin email
        String fromEmail = "anhnvt.23Ite@vku.udn.vn";
        String password = "TuanAnh_205";

        // Tạo mã xác nhận ngẫu nhiên
        String maTeenCode = taoteenCode();
        luutru_teencode = maTeenCode;
        // Cấu hình thông tin máy chủ email
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Tạo phiên làm việc
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // Tạo đối tượng Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Xác nhận mã");

            // Nội dung email
            String emailContent = "Mã xác nhận của bạn là: " + maTeenCode;
            message.setText(emailContent);

            // Gửi email
            Transport.send(message);

            System.out.println("Đã gửi mã xác nhận đến " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String laymaTeenCode() {
    	return luutru_teencode;
    }
    
    private static String taoteenCode() {
        // Tạo mã xác nhận ngẫu nhiên 4 chữ số
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}
