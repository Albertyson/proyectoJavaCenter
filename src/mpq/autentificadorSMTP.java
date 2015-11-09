package mpq;

import javax.mail.PasswordAuthentication;
public class autentificadorSMTP extends javax.mail.Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
	//recuerden cambiar su correo y su contrasena
        return new PasswordAuthentication("jcenteraio@gmail.com", "javacenter");
    }
}
