/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 *
 * @author simon
 */
public class Ini
{
    private final MultiValuedMap<String,String> data=new ArrayListValuedHashMap<>();

    private boolean modified=false;
    private File filename=null;

    public Ini()
    {
    }

    public Ini(final File file) throws IOException
    {
        this.filename=file;
        load();
    }

    public Collection<String> get(final String key)
    {
        return data.get(key);
    }

    public boolean has(final String key)
    {
        return data.containsKey(key);
    }

    public void setFile(final File file)
    {
        filename=file;
    }

    public File getFile()
    {
        return filename;
    }

    public void put(final String key,final Number value)
    {
        put(key,Double.toString(value.doubleValue()));
    }

    public void put(final String key,final String value)
    {
        data.put(key,value);
        modified=true;
    }

    public void remove(final String key)
    {
        data.remove(key);
    }

    public boolean wasModified()
    {
        return modified;
    }

    public void clear()
    {
        data.clear();
        modified=false;
    }

    public final void load() throws IOException
    {
        if(!filename.exists()) throw new FileNotFoundException(filename.getAbsolutePath());
        else if(!filename.canRead()) throw new IOException("File unreadable: "+filename.getAbsolutePath());

        //this.filename=filename;

        data.clear();
        modified=false;

        try(final BufferedReader in=new BufferedReader(new FileReader(filename)))
        {
            for(String buffer=in.readLine();buffer!=null;buffer=in.readLine())
            {
                buffer=buffer.trim();

                if(buffer.isBlank()||buffer.startsWith("#")) continue;

                final int p=buffer.indexOf("=");
                if(p==-1) // No equals...
                {
                    throw new IOException("Misformed ini line in '"+filename+"': '"+buffer+"'");
                }
                else
                {
                    final String key=buffer.substring(0,p).trim();
                    final String value=buffer.substring(p+1).trim();

                    data.put(key,value);
                }
            }
        }
    }

    public void save() throws IOException
    {
        if(filename.exists()&&!filename.canWrite()) throw new IOException("File unwriteable: "+filename.getAbsolutePath());

        try(final PrintWriter out=new PrintWriter(filename))
        {
            out.println("# sQLux configuration file\n");

            final List<String> keys=new ArrayList<>(data.keySet());

            keys.sort(String::compareTo);

            for(final String key:keys)
            {
                for(String datum:get(key))
                {
                    if(datum.startsWith("*"))
                        out.println("# "+key+" = "+datum.substring(1));
                    else out.println(key+" = "+datum);
                }
            }
        }

        modified=false;
    }

    public int size()
    {
        return data.size();
    }

    @Override public boolean equals(Object obj)
    {
        if(!obj.getClass().equals(this.getClass())) return false;

        final Ini b=(Ini)obj;

        if(size()!=b.size()) return false;

        for(String key:data.keySet())
        {
            if(!b.data.containsKey(key)) return false;
            if(!data.get(key).equals(get(key))) return false;
        }

        return true;
    }

    @Override public String toString()
    {
        return data.toString();
    }

    public static void main(final String... args)
    {
        try
        {
            final File testFile=File.createTempFile("ini_test",".ini");

            System.out.println(testFile);

            final Ini a=new Ini();

            a.put("a",1);
            a.put("b",2);
            a.put("c",3);

            System.out.println(a);

            a.setFile(testFile);
            a.save();
            testFile.deleteOnExit();

            try(final BufferedReader in=new BufferedReader(new FileReader(testFile)))
            {
                for(String buffer=in.readLine();buffer!=null;buffer=in.readLine())
                {
                    System.out.println(buffer);
                }
            }

            final Ini b=new Ini(testFile);

            System.out.println(b);

            if(!a.equals(b)) System.out.println("a!=b");
            if(!b.equals(a)) System.out.println("b!=a");

            b.put("d",4);

            if(a.equals(b)) System.out.println("a=b");
            if(b.equals(a)) System.out.println("b=a");

            testFile.deleteOnExit();
        }
        catch(final Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
}