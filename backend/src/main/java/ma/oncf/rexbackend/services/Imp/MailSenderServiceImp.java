package ma.oncf.rexbackend.services.Imp;

import ma.oncf.rexbackend.services.MailSenderService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderServiceImp implements MailSenderService {
    private final JavaMailSender mailSender ;

    public MailSenderServiceImp(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void sendMail(String to, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage() ;
        simpleMailMessage.setFrom("rexapplication0@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);

        mailSender.send(simpleMailMessage);

    }
}
