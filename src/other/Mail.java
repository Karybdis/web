package other;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail
{
    public void sendmail(String email)
    {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  //阿里云把25端口封了，
        props.setProperty("mail.smtp.socketFactory.fallback","false");                        //所以我不得已，
        props.setProperty("mail.smtp.port","465");                                            //把25端口换到465端口，
        props.setProperty("mail.smtp.socketFactory.port","465");                              //采用SSL协议传输邮件。
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try
        {
            message.setFrom(new InternetAddress("firmsun@163.com","ASA"));
            message.setRecipients(Message.RecipientType.TO,email);
            message.setSubject("来自科协报名网站","UTF-8");
            message.setContent("恭喜注册成功！", "text/html;charset=UTF-8");
            message.saveChanges();
            Transport transport = session.getTransport();
            transport.connect("firmsun@163.com", "zjcx1997");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
