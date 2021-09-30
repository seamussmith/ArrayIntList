package main;

import java.util.NoSuchElementException;

public class ArrayIntListIterator
{
    private ArrayList list;
    private int pos = 0;
    private boolean removeOk = false;
    public ArrayIntListIterator(ArrayList list)
    {
        this.list = list;
    }
    public boolean hasNext()
    {
        return pos < list.size();
    }
    public int next()
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
