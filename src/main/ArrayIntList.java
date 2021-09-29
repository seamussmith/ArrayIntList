package main;

public class ArrayIntList
{
    private int[] elementData;
    private int size;
    public ArrayIntList() 
    {
        this(100);
    }
    public ArrayIntList(int num) {
        if (num < 0)
            throw new IllegalArgumentException("yo wtf this num is " +  num + " that dont make sentse");
        elementData = new int[num];
        size = 0;
    }
    public void checkCapacity(int cap)
    {
        if (cap <= 0 || cap > size)
            throw new IllegalStateException("frick");
    }
    public void add(int value)
    {
        elementData[size] = value;
        ++size;
    }
    public int size()
    {
        return size;
    }
    public int get(int i)
    {
        return elementData[i];
    }
    public int indexOf(int value)
    {
        for (var i = 0; i < size; ++i)
            if (elementData[i] == value)
                return i;
        return -1;
    }
    public void remove(int index)
    {
        for (var i = index; i < size -1; ++i)
            elementData[i] = elementData[i + 1];
        --size;
    }
    public void add(int index, int value)
    {
        for (var i = size; i >= index + 1; --i)
            elementData[i] = elementData[i-1];
        elementData[index] = value;
        ++size;
    }
    public boolean contains(int value)
    {
        return indexOf(value) >= 0;
    }
}
