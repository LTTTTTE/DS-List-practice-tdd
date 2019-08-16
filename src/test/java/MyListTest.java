import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyListTest {

    private MyList myList;

    @Test
    public void testInit(){
        MyList list = new MyList();
        assertThat(list).isNotNull();
    }

    @Before
    public void init(){
        myList = new MyList();

    }
}
