package ma.oncf.rexbackend.services;

public interface MailSenderService {

    void sendMail(String to ,String subject , String message ) ;
}
