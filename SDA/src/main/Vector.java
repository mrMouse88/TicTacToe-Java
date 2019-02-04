package main;

import java.util.Scanner;

public class Vector
{
    protected double[] coords;
   
    public Vector(double... c)
    {
        if(c != null)
        {
            int i,n = c.length;
            coords = new double[n];
            for(i=0;i<n;i++)
            {
                coords[i] = c[i];
            }
        }
        else coords = new double[0];
    }
   
    public double scalarProduct(Vector v) throws Exception
    {
        if(v == null) throw new NullPointerException();
       
        if(this.coords.length != v.coords.length) throw new Exception("Niezgodne długości wektorów");
        int i,n = coords.length;
        double result = 0;
       
        for(i=0;i<n;i++)
        {
            result += coords[i] * v.coords[i];
        }
       
        return result;
    }
   
    public static void main(String... args)
    {
        Vector a = new Vector(1,2);
        //Vector b = null;
        //Vector b = new Vector(3,4,5);
        Vector b = new Vector(3,4);
       
        Scanner odczyt = new Scanner(System.in);
        double q = odczyt.nextDouble();
        double w = odczyt.nextDouble();
       
        Vector c = new Vector(q,w);
       
       
        try
        {
            double x = a.scalarProduct(b);
            System.out.println("Produkt skalarny to: " + x);

            x = b.scalarProduct(a);
            System.out.println("Produkt skalarny to: " + x);

            x = c.scalarProduct(a);
            System.out.println("Produkt skalarny to: " + x);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
