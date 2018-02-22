package music;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class UserProps implements Serializable {

    @Getter
    private List<String> garbage;

    @Value("${garbage}")
    public void setGarbage(String[] garbage) {
        this.garbage = Arrays.asList(garbage);
    }


}
