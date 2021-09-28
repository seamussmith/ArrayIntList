package main;

public class ArrayIntList
{
    private int[] elementData;
    private int size;
    public ArrayIntList() {
        elementData = new int[100];
        size = 0;
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
}
