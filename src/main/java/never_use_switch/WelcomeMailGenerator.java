package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        // 80 lines of code
        return "<html> Welcome new client</html>";
    }

    @Override
    public int myCode() {
        return 1;
    }
}
