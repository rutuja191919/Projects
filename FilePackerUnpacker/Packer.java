import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Binary IO code : any file pdf, mp3
class Packer
{
    public static void main(String args[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter directory/folder name");
            String foldername = sobj.nextLine();

            File dobj = new File(foldername);

            File allfiles[] = dobj.listFiles();
            String name;

            System.out.println("Enter packed file name");
            String packfilename = sobj.nextLine();

            File fobj = new File(packfilename);
            boolean bobj = fobj.createNewFile();

            FileInputStream readerobj = null;
            byte buffer[] = new byte[100];

            int ret = 0;

            FileOutputStream writerobj = new FileOutputStream(fobj);

            for(int i = 0; i< allfiles.length; i++)
            {
                name = allfiles[i].getName();

                if(name.endsWith(".txt"))
                {
                    name = name +" "+(allfiles[i].length());
                    System.out.println(name);

                    for(int j = name.length(); j < 100; j++)
                    {
                        name = name + " ";
                    }
                    System.out.println(name.length());

                    byte header[] = name.getBytes();

                    writerobj.write(header,0,header.length);

                    readerobj = new FileInputStream(allfiles[i]);

                    while((ret = readerobj.read(buffer)) != -1)
                    {
                        writerobj.write(buffer,0,ret);
                    }
                }   
            }     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}