import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyListTest {

    private MyList myList;

    @Before
    public void init(){
        myList = new MyList();
        myList.add("10"); myList.add("20"); myList.add("30");
        myList.add("40"); myList.add("50"); myList.add("60");
        myList.add("70"); myList.add("80"); myList.add("90");
    }

    @Test
    public void testInit(){
        MyList list = new MyList();
        assertThat(list).isNotNull();
    }

    @Test
    public void testAdd(){
        MyList list = new MyList();
        list.add("10");
        assertThat(list.get(0)).isEqualTo("10");
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void testEmptyClear(){
        myList.clear();
        assertThat(myList.isEmpty()).isTrue();
    }

    @Test
    public void testIndexOf(){
        assertThat(myList.indexOf("30")).isEqualTo(2);
    }

    @Test
    public void testLastIndexOf(){
        myList.add("30");
        assertThat(myList.indexOf("30")).isNotEqualTo(myList.lastIndexOf("30"));
    }

    @Test
    public void testContains(){
        assertThat(myList.contains("30")).isTrue();
    }

    @Test
    public void testContainsAll(){
        List<String> anotherList = new ArrayList<>();
        anotherList.add("10");anotherList.add("90");
        anotherList.add("20");anotherList.add("80");
        assertThat(myList.containsAll(anotherList)).isTrue();
    }

}
