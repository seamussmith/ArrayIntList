package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList<TElement> implements Iterable<TElement>
{
    private TElement[] elementData;
    private int size;
    public ArrayList()
    {
        this(100);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int num)
    {
        if (num < 0)
            throw new IllegalArgumentException("yo wtf this num is " + num + "that dont make sentse");
        elementData = (TElement[]) new Object[num];
        size = 0;
    }
    private void ensureCapacity(int cap)
    {
        int newCap = elementData.length * 2 + 1;
        if (cap > newCap)
            newCap = cap;
        elementData = Arrays.copyOf(elementData, newCap);
    }
    public void add(TElement value)
    {
        ensureCapacity(size);
        elementData[size] = value;
        ++size;
    }
    public void set(int i, TElement val)
    {
        elementData[i] = val;
    }
    public int size()
    {
        return size;
    }
    public TElement get(int i)
    {
        return elementData[i];
    }
    public int indexOf(TElement value)
    {
        for (var i = 0; i < size; ++i)
            if (elementData[i].equals(value))
                return i;
        return -1;
    }
    public void remove(int index)
    {
        for (var i = index; i < size -1; ++i)
            elementData[i] = elementData[i + 1];
        --size;
    }
    public void add(int index, TElement value)
    {
        ensureCapacity(index + 1);
        for (var i = size; i >= index + 1; --i)
            elementData[i] = elementData[i-1];
        elementData[index] = value;
        ++size;
    }
    public void addAll(ArrayList<TElement> other)
    {
        ensureCapacity(size + other.size());
        for (int i = 0; i < other.size(); ++i)
            add(other.get(i));
    }
    public boolean contains(TElement value)
    {
        return indexOf(value) >= 0;
    }
    public ArrayIntListIterator<TElement> iterator()
    {
        return new ArrayIntListIterator<TElement>(this);
    }
    public void replaceAll(TElement old, TElement newEl)
    {
        var iter = iterator();
        while (iter.hasNext())
        {
            var el = iter.next();
            if (el.equals(old))
                iter.set(newEl);
        }
    }
    @SuppressWarnings("unchecked")
    public void reverse()
    {
        var newArr = (TElement[]) new Object[elementData.length];
        var j = 0;
        for (var i = size-1; i >= 0; --i, ++j)
            newArr[j] = elementData[i];
        elementData = newArr;
    }
    public void mirror()
    {
        var copy = Arrays.copyOf(elementData, size);
        for (var i = size-1; i >= 0; --i)
            add(copy[i]);
    }
}
