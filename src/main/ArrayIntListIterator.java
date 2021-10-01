package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIntListIterator<TElement> implements Iterator<TElement>
{
    private ArrayList<TElement> list;
    private int pos = 0;
    private boolean removeOk = false;
    public ArrayIntListIterator(ArrayList<TElement> list)
    {
        this.list = list;
    }
    public boolean hasNext()
    {
        return pos < list.size();
    }
    public TElement next()
    {
        if (!hasNext())
            throw new NoSuchElementException();
        ++pos;
        removeOk = true;
        return list.get(pos-1);
    }
    public void remove()
    {
        if (!removeOk)
            throw new IllegalStateException("what the heck man youse already removes it");
        list.remove(pos - 1);
        --pos;
        removeOk = false;
    }
}
