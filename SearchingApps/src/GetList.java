/*
 * This program extract the program's name available in start menu.
 * This code is originally for windows 8 and windows 8.1
 * Tweaking progFile might work in some other version of windows
 */



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GetList {
    public List<String> stack;
    static List<String> lnkFile;
    static List<String> progName;

    int index=-1;
    public static void main(String args[]) throws IOException
    {
        //String progFile="C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\";


        //var-- progFile:Location of the file to be search. Should be always the root file.
        String progFile="C:\\";
        GetList obj=new GetList();
        String temp=progFile;
        int i;
        while(!"&%@#".equals(temp))
        {
            File dir=new File(temp);
            String[] directory=dir.list();
            if(directory!=null){
            for(String name: directory)
            {
                if(new File(temp+name).isDirectory())
                    obj.push(temp+name+"\\");
                else
                    if(new File(temp+name).isFile())
                    {
                        try{
                            //".exe can be replaced with file name to be searched. Just exclude name.substring()... you know what to do.:)
                        if(".exe".equals(name.substring(name.lastIndexOf('.'), name.length())))
                        	//if("notepad.exe".equals(name.substring(name.lastIndexOf('\\'), name.length())))	
                        {
                            //obj.addFile(temp+name,name);
                            System.out.println(temp+name);
                        }
                        }catch(StringIndexOutOfBoundsException e)
                        {
                            //System.out.println("ERROR******"+temp+name);
                        }

                    }
            }}
            temp=obj.pop();
        }
        obj.display();

//        for(int i=0;i<directory.length;i++)
//        System.out.println(directory[i]);
    }

    public GetList() {
        this.stack = new ArrayList<String>();
        this.lnkFile=new ArrayList<String>();
        this.progName=new ArrayList<String>();
    }
    public void push(String dir)
    {
        index++;
        //System.out.println("PUSH : "+dir+" "+index);
        this.stack.add(index,dir);

    }
    public String pop()
    {
        String dir="";
        if(index==-1)
            return "&%@#";
        else
        {
            dir=this.stack.get(index);
            //System.out.println("POP : "+dir+" "+index);
            index--;

        }
        return dir;
    }



    public void addFile(String name,String name2)
    {
        lnkFile.add(name);
        progName.add(name2);
    }



    public void display()
    {

        /*GetList.lnkFile.stream().forEach((lnkFile1) -> {
            System.out.println(lnkFile1);
        });*/


    }

}
