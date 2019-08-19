import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<String> implements List<String> {

    private int size;
    private String[] array;

    public MyList() {
        this.size = 0;
        array = (String[]) new Object[1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        array = (String[]) new Object[1];
        System.gc();
    }

    @Override
    public String get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return array[index] = element;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        for(Object s : c){
            flag &= contains(s);
        }
        return flag;
    }

    @Override
    public boolean add(String string) {
        if(size >= array.length){
            String[] newArray = (String[]) new Object[size * 2];
            System.arraycopy(array,0, newArray,0, array.length);
            array = newArray;
        }
        array[size++] = string;
        return true;
    }

    @Override
    public void add(int index, String element) {
        if(index == size){
            add(element);
            return;
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(size >= array.length){
            String[] newArray = (String[]) new Object[size * 2];
            System.arraycopy(array,0, newArray,0, array.length);
            array = newArray;
        }
        size++;
        for(int i = size - 1; i > index; i--){
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean flag = true;
            for(String s : c){
                flag &= add(s);
            }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        int beforeSize = size;
        for(String s : c){
            add(index++, s);
        }
        return beforeSize + c.size() == size;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public java.lang.String toString(){
        java.lang.String str = "[";
        for(int i = 0; i < size; i++){
            str += array[i];
            if(i != size -1){
                str += ", ";
            }
        }
        return str + "]";
    }
}
