package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class SparkAdvertisementMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        return "Spark is the BEST!!!";
    }

    @Override
    public int myCode() {
        return 3;
    }
}
