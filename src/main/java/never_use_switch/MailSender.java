package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Service
public class MailSender {

    @Autowired
    private MailDao mailDao;

    private Map<Integer, MailGenerator> map = new HashMap<>();


    @Autowired
    public void configureMap(List<MailGenerator> mailGenerators) {
        for (MailGenerator mailGenerator : mailGenerators) {
            int code = mailGenerator.myCode();
            if (map.containsKey(code)) {
                throw new RuntimeException(code + " already in use");
            }
            map.put(code, mailGenerator);
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void sendMail() {
        MailInfo mailInfo = mailDao.getMailInfo();
        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        String html = mailGenerator.generateHtml(mailInfo);
        send(html);
    }

    private void send(String html) {
        System.out.println("sending... "+html);
    }
}
