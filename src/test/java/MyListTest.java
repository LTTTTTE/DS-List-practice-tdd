import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyListTest {

    private MyList<String> myList;

    @Before
    public void init(){
        myList = new MyList<>();
        myList.add("10"); myList.add("20"); myList.add("30");
        myList.add("40"); myList.add("50"); myList.add("60");
        myList.add("70"); myList.add("80"); myList.add("90");
    }

    @Test
    public void testInit(){
        MyList<String> list = new MyList<>();
        assertThat(list).isNotNull();
    }

    @Test
    public void testAdd(){
        MyList<String> list = new MyList<>();
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

    @Test
    public void testAddIndex(){
        myList.add(0,"5");
        myList.add(1,"8");
        myList.add(10,"88");
        myList.add(12,"99");
        assertThat(myList.size()).isEqualTo(13);
        assertThat(myList.containsAll(new ArrayList<>(Arrays.asList("5","8","88","99"))))
                .isTrue();
        assertThat(myList.toString()).isEqualTo("[5, 8, 10, 20, 30, 40, 50, 60, 70, 80, 88, 90, 99]");
    }

    @Test
    public void testAddAll(){
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("5", "8", "88", "99"));
        myList.addAll(arrayList);
        assertThat(myList.containsAll(arrayList));
        System.out.println(myList.toString());
    }

    @Test
    public void testAddAllIndex(){
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("5", "8", "88", "99"));
        myList.addAll(5,arrayList);
        assertThat(myList.size()).isEqualTo(13);
        assertThat(myList.toString()).isEqualTo("[10, 20, 30, 40, 50, 5, 8, 88, 99, 60, 70, 80, 90]");
    }

    @Test
    public void testRemove(){
        myList.remove("20");
        assertThat(myList.size()).isEqualTo(8);
        assertThat(myList.toString()).isEqualTo("[10, 30, 40, 50, 60, 70, 80, 90]");

        myList.remove("10");
        assertThat(myList.size()).isEqualTo(7);
        assertThat(myList.toString()).isEqualTo("[30, 40, 50, 60, 70, 80, 90]");
    }

    @Test
    public void testRemoveIndex(){
        myList.remove(8);
        assertThat(myList.size()).isEqualTo(8);
        assertThat(myList.toString()).isEqualTo("[10, 20, 30, 40, 50, 60, 70, 80]");

        myList.remove(6);
        assertThat(myList.size()).isEqualTo(7);
        assertThat(myList.toString()).isEqualTo("[10, 20, 30, 40, 50, 60, 80]");
    }

    @Test
    public void testRemoveAll(){
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("20", "10", "80", "90"));
        myList.removeAll(strings);
        assertThat(myList.size()).isEqualTo(5);
        assertThat(myList.toString()).isEqualTo("[30, 40, 50, 60, 70]");
    }

    @Test
    public void testRetainAll(){
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("20", "10", "80", "90"));
        myList.retainAll(strings);
        assertThat(myList.size()).isEqualTo(4);

    }
}
