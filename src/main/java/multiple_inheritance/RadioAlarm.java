package multiple_inheritance;

import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
public class RadioAlarm implements Radio, Alarm {
    @Delegate
    private Alarm alarm = new AlarmImpl();
    @Delegate
    private Radio radio = new RadioImpl();
}
