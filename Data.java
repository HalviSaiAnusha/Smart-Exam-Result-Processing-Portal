import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
class Demo
{
    public static void main(String[] args)
    {
        try
        {
            File myfile1=new File("2019.txt");
            if(myfile1.createNewFile()){
            FileWriter my1 = new FileWriter("2019.txt");
            my1.write("Math-Oops-Arm-Co\n");
            for(int i=0;i<80;i++)
            {
                int m1=new Random().nextInt(91)+10;
                int m2=new Random().nextInt(91)+10;
                int m3=new Random().nextInt(91)+10;
                int m4=new Random().nextInt(91)+10;
                my1.write(m1+"-"+m2+"-"+m3+"-"+m4+"\n");
            }
            my1.close();
        }
        else
        {
            System.out.println("file not created");
        }
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            File myfile2=new File("2018.txt");
            if(myfile2.createNewFile()){
            FileWriter my2 = new FileWriter("2018.txt");
            my2.write("Math-Oops-Arm-Co\n");
            for(int i=0;i<80;i++)
            {
                int m1=new Random().nextInt(81)+20;
                int m2=new Random().nextInt(81)+20;
                int m3=new Random().nextInt(81)+20;
                int m4=new Random().nextInt(81)+20;
                my2.write(m1+"-"+m2+"-"+m3+"-"+m4+"\n");
            }
            my2.close();
        }
        else
        {
            System.out.println("file not created");
        }
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            File myfile3=new File("2017.txt");
            if(myfile3.createNewFile()){
            FileWriter my3 = new FileWriter("2017.txt");
            my3.write("Math-Oops-Arm-Co\n");
            for(int i=0;i<80;i++)
            {
                int m1=new Random().nextInt(71)+30;
                int m2=new Random().nextInt(71)+30;
                int m3=new Random().nextInt(71)+30;
                int m4=new Random().nextInt(71)+30;
                my3.write(m1+"-"+m2+"-"+m3+"-"+m4+"\n");
            }
            my3.close();
        }
        else
        {
            System.out.println("file not created");
        }
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            File myfile4=new File("2016.txt");
            if(myfile4.createNewFile()){
            FileWriter my4 = new FileWriter("2016.txt");
            my4.write("Math-Oops-Arm-Co\n");
            for(int i=0;i<80;i++)
            {
                int m1=new Random().nextInt(91)+10;
                int m2=new Random().nextInt(91)+10;
                int m3=new Random().nextInt(91)+10;
                int m4=new Random().nextInt(91)+10;
                my4.write(m1+"-"+m2+"-"+m3+"-"+m4+"\n");
            }
            my4.close();
        }
        else
        {
            System.out.println("file not created");
        }
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            File myfile5=new File("2015.txt");
            if(myfile5.createNewFile()){
            FileWriter my5 = new FileWriter("2015.txt");
            my5.write("Math-Oops-Arm-Co\n");
            for(int i=0;i<80;i++)
            {
                int m1=new Random().nextInt(91)+10;
                int m2=new Random().nextInt(91)+10;
                int m3=new Random().nextInt(91)+10;
                int m4=new Random().nextInt(91)+10;
                my5.write(m1+"-"+m2+"-"+m3+"-"+m4+"\n");
            }
            my5.close();
        }
        else
        {
            System.out.println("file not created");
        }
        }
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }    
}