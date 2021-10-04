package main;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayIntListIterator<TElement> implements ListIterator<TElement>
{
    private ArrayList<TElement> list;
    private int pos = 0;
    private boolean removeOk = false;
    public ArrayIntListIterator(ArrayList<TElement> list)
    {
        this.list = list;
    }
    @Override
    public boolean hasNext()
    {
        return pos < list.size();
    }
    @Override
    public TElement next()
    {
        if (!hasNext())
            throw new NoSuchElementException();
        ++pos;
        removeOk = true;
        return list.get(pos-1);
    }
    @Override
    public void remove()
    {
        if (!removeOk)
            throw new IllegalStateException("what the heck man youse already removes it");
        list.remove(pos - 1);
        --pos;
        removeOk = false;
    }
    @Override
    public void set(TElement val)
    {
        list.set(pos, val);
    }
    @Override
    public boolean hasPrevious()
    {
        return pos-1 > 0;
    }
    @Override
    public TElement previous()
    {
        if (!hasPrevious())
            throw new NoSuchElementException();
        --pos;
        removeOk = true;
        return list.get(pos);
    }
    @Override
    public int nextIndex()
    {
        if (!hasNext())
            throw new NoSuchElementException();
        ++pos;
        removeOk = true;
        return pos-1;
    }
    @Override
    public int previousIndex()
    {
        if (!hasPrevious())
            throw new NoSuchElementException();
        --pos;
        removeOk = true;
        return pos;
    }
    @Override
    public void add(TElement e)
    {
        list.add(pos, e);
    }
}
