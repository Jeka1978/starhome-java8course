package callback_pattern;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ListUtilTest {


    @Test
    public void countDuplicates() throws Exception {
        List<String> list = Arrays.asList("Java", "java", "Scala", "groovy");

        int count = ListUtil.countDuplicates(list, "java",  (t1, o) -> t1.equalsIgnoreCase(o));
        Assert.assertEquals(2,count);
    }

}