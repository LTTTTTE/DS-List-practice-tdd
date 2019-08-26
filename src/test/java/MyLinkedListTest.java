import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLinkedListTest {
    @Test
    public void testInit(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        assertThat(myLinkedList).isNotNull();
    }
}
