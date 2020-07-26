package mascotas.perdidas.services;


import org.springframework.stereotype.Service;


public interface EmailService {
    public void sendSimpleMessage( String to, String subject, String text);
}
