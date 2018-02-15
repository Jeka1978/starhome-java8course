package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {

    @Autowired
    private MailDao mailDao;

    @Autowired
    private Map<String, MailGenerator> map;

    @Scheduled(fixedDelay = 1000)
    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        MailGenerator mailGenerator = map.get(Integer.toString(mailInfo.getMailCode()));
        String html = mailGenerator.generateHtml(mailInfo);
        send(html);
    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
