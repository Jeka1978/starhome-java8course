package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {

    @Autowired
    private MailDao mailDao;

    @Scheduled(fixedDelay = 1000)
    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        switch (mailInfo.getMailCode()) {
            case 1:
                System.out.println("Welcome new client mail sent");
                // 80 lines of code
                break;
            case 2:
                // 100 lines of code
                System.out.println("don't call us we call you mail sent");
                break;
        }
    }
}
