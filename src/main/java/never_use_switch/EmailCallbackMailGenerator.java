package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHtml(MailInfo mailInfo) {
        // 80 lines of code
        return "<html> don't call us we call you</html>";
    }

    @Override
    public int myCode() {
        return 2;
    }
}
