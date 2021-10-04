package main;

public class App
{
    public static void main(String[] args) 
    {
        var a = new ArrayList<Integer>(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.reverse();
        a.mirror();
        for (var i : a)
            System.out.println(i);
    }
}
