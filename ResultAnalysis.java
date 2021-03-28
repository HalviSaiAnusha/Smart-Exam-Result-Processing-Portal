import java.util.*;
import java.util.Map.Entry;

import java.io.File;
import java.io.FileNotFoundException;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import analyticalmethods.*;

class ResultAnalysis
{
	public static float[] getData(int a) {
		float[] avgData = new float[5];
		int[] d = new int[80];
		int[] d1 = new int[80];
		int[] d2 = new int[80];
		int[] d3 = new int[80];
		int[] d4 = new int[80];
		int c = 0; 
		 try {
		      File myObj = new File("E:\\Processing\\Results Processing\\src\\2015.txt");
		      File myObj1 = new File("E:\\Processing\\Results Processing\\src\\2016.txt");
		      File myObj2 = new File("E:\\Processing\\Results Processing\\src\\2017.txt");
		      File myObj3 = new File("E:\\Processing\\Results Processing\\src\\2018.txt");
		      File myObj4 = new File("E:\\Processing\\Results Processing\\src\\2019.txt");
		      Scanner myReader = new Scanner(myObj);
		      Scanner myReader1 = new Scanner(myObj1);
		      Scanner myReader2 = new Scanner(myObj2);
		      Scanner myReader3 = new Scanner(myObj3);
		      Scanner myReader4 = new Scanner(myObj4);
		      myReader.nextLine();myReader1.nextLine();myReader2.nextLine();myReader3.nextLine();myReader4.nextLine();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        d[c] = Integer.parseInt(data.substring(a,a+2));
		        data = myReader1.nextLine();
		        d1[c] = Integer.parseInt(data.substring(a,a+2));
		        data = myReader2.nextLine();
		        d2[c] = Integer.parseInt(data.substring(a,a+2));
		        data = myReader3.nextLine();
		        d3[c] = Integer.parseInt(data.substring(a,a+2));
		        data = myReader4.nextLine();
		        d4[c] = Integer.parseInt(data.substring(a,a+2));
		        c++;
		      }
		      myReader.close();
		      myReader1.close();
		      myReader2.close();
		      myReader3.close();
		      myReader4.close();
		    } 
			 catch (FileNotFoundException e) {
			 System.out.println("An error occurred.");
			 e.printStackTrace();
		 }
		methods innerm = new methods();
		avgData[0] = innerm.findAverage(d);
		avgData[1] = innerm.findAverage(d1);
		avgData[2] = innerm.findAverage(d2);
		avgData[3] = innerm.findAverage(d3);
		avgData[4] = innerm.findAverage(d4);
		return avgData;
	}
	public static void predict() {
		Scanner sc=new Scanner(System.in);
		methods m = new methods();
		System.out.println("Select Any Subject for which you want to predict class average mark\nMATHS-1,OOPS-2,ARM-3,CO-4");
		float[] averages = new float[5];
		int ch = sc.nextInt();
		int[] years = new int[]{2015,2016,2107,2018,2019};
		double[] result = new double[2];
		String curr;
		if(ch==1) {
			System.out.println("Maths Class Average Prediction:");
			averages = getData(0);
			result =  m.LinearRegression(years, averages);
			curr = "Maths";
		}
		else if(ch==2) {
			System.out.println("OOPS Class Average Prediction:");
			averages = getData(3);
			result =  m.LinearRegression(years, averages);
			curr = "OOPS";
		}
		else if(ch==3) {
			System.out.println("ARM Class Average Prediction:");
			averages = getData(6);
			result =  m.LinearRegression(years, averages);
			curr = "ARM";
		}
		else {
			System.out.println("CO Class Average Prediction:");
			averages = getData(9);
			result =  m.LinearRegression(years, averages);
			curr = "CO";
		}
		System.out.println("Year Wise Class Average");
		System.out.println("2015 - "+averages[0]);
		System.out.println("2016 - "+averages[1]);
		System.out.println("2017 - "+averages[2]);
		System.out.println("2018 - "+averages[3]);
		System.out.println("2019 - "+averages[4]);
		System.out.println("Slope of Line fit: "+result[0]);
		System.out.println("Intercept of Line fit: "+result[1]);
		float year2020 = (float) (result[0]*(2020) + result[1]);
		float year2021 = (float) (result[0]*(2021) + result[1]);
		float year2019 = (float) (result[0]*(2019) + result[1]);
		float year2022 = (float) (result[0]*(2022) + result[1]);
		System.out.println("Class Average Prediction for year 2020: "+year2020);
		Map< String,Float> hm =  new LinkedHashMap< String,Float>();
		hm.put("2019", year2019); 
		hm.put("2020", year2020); 
	    hm.put("2021", year2021); 
	    hm.put("2022", year2022); 
		LineChart_AWT chart = new LineChart_AWT(
		         "Mark Vs Years" ,
		         "Average Marks vs Years"+"("+curr+")",hm);
		chart.pack( );
		RefineryUtilities.centerFrameOnScreen( chart );
		chart.setVisible( true );
	}
	public static void main(String[] args)
	{
		methods m = new methods();
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER NUMBER OF STUDENTS IN THE EACH CLASS");
		int n=sc.nextInt();
		float avg1=0;
		float avg2=0;
		float avg3=0;
		float avg4=0;
		double sd1=0;
		double sd2=0;
		double sd3=0;
		double sd4=0;
		int[] arm=new int[n];
		int[] co=new int[n];
		int[] maths=new int[n];
		int[] oops=new int[n];
		System.out.println("ENTER NUMBER OF TEACHERS");
		int n1=sc.nextInt();	
		Teacher arr1[]=new Teacher[n1];
		for(int j=0;j<n1;j++)
		{
			arr1[j]=new Teacher();
			arr1[j].getDetails1();
		}
		for(int j=0;j<n1;j++)
		{
			arr1[j].display1();
		}
		int x1=1;
		while(x1 == 1) {
		System.out.println("Enter Marks-1,Predict Average Marks-2\nExit-Any Value");
		int ch = sc.nextInt();
		if(ch == 1) {			
		int x=1;
		while(x==1){
			String[] mssgs = new String[n];
			String[] mails = new String[n];
			System.out.println("Select Section :Class-1,Class-2,Class-3\nExit-Any Value");
			int section = sc.nextInt();
			switch(section){
				case 1:
						StudentA arr[] =new StudentA[n];	
						for(int i=0;i<n;i++)
						{
							arr[i]=new StudentA();
							arr[i].getDetails();
							mails[i] = arr[i].mail;
						}
						for(int j=0;j<n;j++)
						{
							System.out.println("---------------------------------------STUDENTS DETAILS---------------------------------------");
							arr[j].display();
						}	
						for(int i=0;i<n;i++)
						{
							arm[i] = arr[i].arm;
							co[i] = arr[i].co;
							maths[i] = arr[i].math;
							oops[i] = arr[i].oops;
							float percentage = arm[i]+co[i]+maths[i]+oops[i];
							percentage = percentage/4;
							mssgs[i] = "Name: "+arr[i].name+"\nUSN: "+arr[i].usn+"\n\nScored Marks "+"\nARM - "+arr[i].arm+"\nCO - "+arr[i].co+"\nMaths - "+arr[i].math+"\nOOPS - "+arr[i].oops+"\nPercentage: "+percentage;
						}
						break;
				case 2:
						StudentB arr2[] =new StudentB[n];	
						for(int i=0;i<n;i++)
						{
							arr2[i]=new StudentB();
							arr2[i].getDetails();
							mails[i] = arr2[i].mail;
						}
						for(int j=0;j<n;j++)
						{
							System.out.println("---------------------------------------TEACHERS DETAILS---------------------------------------");
							arr2[j].display();
						}	
						for(int i=0;i<n;i++)
						{
							arm[i] = arr2[i].arm;
							co[i] = arr2[i].co;
							maths[i] = arr2[i].math;
							oops[i] = arr2[i].oops;
							float percentage1 = arm[i]+co[i]+maths[i]+oops[i];
							percentage1 = percentage1/4;
							mssgs[i] = "Name: "+arr2[i].name+"\nUSN: "+arr2[i].usn+"\n\nScored Marks "+"\nARM - "+arr2[i].arm+"\nCO - "+arr2[i].co+"\nMaths - "+arr2[i].math+"\nOOPS - "+arr2[i].oops+"\nPercentage: "+percentage1;
						}
						break;
				case 3:
						StudentC arr3[] =new StudentC[n];	
							for(int i=0;i<n;i++)
							{
								arr3[i]=new StudentC();
								arr3[i].getDetails();
								mails[i] = arr3[i].mail;
							}
							for(int j=0;j<n;j++)
							{
								arr3[j].display();
							}	
							for(int i=0;i<n;i++)
							{
								arm[i] = arr3[i].arm;
								co[i] = arr3[i].co;
								maths[i] = arr3[i].math;
								oops[i] = arr3[i].oops;
								float percentage2 = arm[i]+co[i]+maths[i]+oops[i];
								percentage2 = percentage2/4;
								mssgs[i] = "Name: "+arr3[i].name+"\nUSN: "+arr3[i].usn+"\n\nScored Marks: "+"\nARM - "+arr3[i].arm+"\nCO - "+arr3[i].co+"\nMaths - "+arr3[i].math+"\nOOPS - "+arr3[i].oops+"\nPercentage: "+percentage2;
							}
							break;
				default:x=0;
						break;
			}
			avg1 = m.findAverage(arm); 
			avg2 = m.findAverage(co); 
			avg3 = m.findAverage(maths); 
			avg4 = m.findAverage(oops); 
			sd1 = m.findSD(arm);
			sd2 = m.findSD(co);
			sd3 = m.findSD(maths);
			sd4 = m.findSD(oops);
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			Properties props = System.getProperties();
		    props.setProperty("mail.smtp.host", "smtp.gmail.com");
		    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		    props.setProperty("mail.smtp.socketFactory.fallback", "false");
		    props.setProperty("mail.smtp.port", "465");
		    props.setProperty("mail.smtp.socketFactory.port", "465");
	     	props.put("mail.smtp.auth", "true");
		    props.put("mail.debug", "true");
		    props.put("mail.store.protocol", "pop3");
		    props.put("mail.transport.protocol", "smtp");
		    final String username = "nhceresultportal@gmail.com";
		    final String password = "NHCE_Admin2146";
		    try{
		        Session session = Session.getDefaultInstance(props, 
		                             new Authenticator(){
		                                protected PasswordAuthentication getPasswordAuthentication() {
		                                   return new PasswordAuthentication(username, password);
		                                }});
		        Message msg = new MimeMessage(session);
		        msg.setFrom(new InternetAddress("nhceresultportal@gmail.com"));
		        msg.setSubject("Exam Results");
		        for(int i=0;i<n;i++) {
		        	if(mails[i] != null) {
		        	 msg.setRecipients(Message.RecipientType.TO, 
	                 InternetAddress.parse(mails[i],false));
		        	 String text = mssgs[i];
		        	 text += "\n\nClass Average of Each Subject: "+"\nARM - "+avg1+"\nCO - "+avg2+"\nMaths - "+avg3+"\nOOPS - "+avg4;
		        	 msg.setText(text);
		        	 msg.setSentDate(new Date());
		        	 Transport.send(msg);
		        	 System.out.println("Message sent.");
		        	}
			    }
		     }
		    catch (MessagingException e){ 
		    	System.out.println("Error: " + e);
		    }
		}
		}
		else if(ch == 2) {
			predict();
		}
		else {
			x1 = 0;
		}
		}
			System.out.println("-----------------------------------Averages of Each Subject----------------------------------");
			System.out.println("ARM : "+avg1);
			System.out.println("CO : "+avg2);
			System.out.println("MATHS : "+avg3);
			System.out.println("OOPS : "+avg4+"\n");
			System.out.println("-----------------------------------Standard Deviation of Each Subject----------------------------------");
			System.out.println("ARM : "+sd1);
			System.out.println("CO : "+sd2);
			System.out.println("MATHS : "+sd3);
			System.out.println("OOPS : "+sd4+"\n");
		}
	}
interface ioStudent{
	public void print();
	public void display();
	public void getDetails();
}
interface ioTeacher{
	public void display1();
	public void getDetails1();
}
class Student implements ioStudent
{
	String name;
	int usn;
	String mail;
	int sec;
	int math;
	int oops;
	int arm;
	int co;
	float avg;
	@Override
	public void print()
	{
		float sum=(math+oops+arm+co);
		avg=((sum/400)*100);
		System.out.println("YOUR PERCENTAGE IS = "+avg);
	}
	Student()
	{
		name="xxx";
		usn=71;
		mail="xxx@gmail.com";
		sec=0;
		math=0;
		oops=0;
		arm=0;
		co=0;
	}
	Scanner sc = new Scanner(System.in);
	@Override
    public void display()
    {
        System.out.println("---------------------------------------------INFO---------------------------------------------"+"\nNAME= "+name+"\nUSN= "+usn+"\nMAILID= "+mail+"\nSEC= "+sec+"\nMARKS IN MATH SUBJECT= "+math+"\nMARKS IN OOPS SUBJECT= "+oops+"\nMARKS IN ARM SUBJECT= "+arm+"\nMARKS IN CO SUBJECT= "+co+"\n");
	}
	@Override
	public void getDetails(){
			System.out.println("ENTER THE NAME OF THE STUDENT");
			this.name=sc.nextLine();
			System.out.println("ENTER THE USN");
			this.usn=sc.nextInt();
			sc.nextLine();
			System.out.println("ENTER YOUR MAIL");
			this.mail=sc.nextLine();
			System.out.println("ENTER THE MARKS OF MATHS");
			this.math=sc.nextInt();
			System.out.println("ENTER THE MARKS OF OOPS");
			this.oops=sc.nextInt();
			System.out.println("ENTER THE MARKS OF ARM");
			this.arm=sc.nextInt();
			System.out.println("ENTER THE MARKS OF CO");
			this.co=sc.nextInt();
	}
}
class StudentA extends Student{
	StudentA(){
		this.sec = 1;
	}
}
class StudentB extends Student{
	StudentB(){
		this.sec = 2;
	}
}
class StudentC extends Student{
	StudentC(){
		this.sec = 3;
	}
}
class Teacher implements ioTeacher
{
	String name;
	String mail;
	String sub;
	int[] num = new int[2];
	Scanner sc = new Scanner(System.in);
	Teacher()
	{
		name="xxx";
		mail="xxx@gmail.com";
		sub="xxx";
		num=new int[]{1,2};
	}
	@Override
	public void getDetails1(){
		System.out.println("ENTER NAME OF THE TEACHER");
		this.name=sc.nextLine();
		System.out.println("ENTER EMAIL OF THE TEACHER");
		this.mail=sc.nextLine();
		System.out.println("ENTER SUBJECT OF THE TEACHER");
		this.sub=sc.nextLine();
		System.out.println("ENTER SECTIONS A TEACHER HANDLES");
		this.num[0]=sc.nextInt();
		this.num[1]=sc.nextInt();
	}
	@Override
	public void display1()
	{
		System.out.println("---------------------------------------------INFO---------------------------------------------"+"\nNAME="+name+"\nMAILID= "+mail+"\nSUBJECT="+sub+"\nSECTIONS HANDLING="+num[0]+","+num[1]+"\n");
	}
}

class LineChart_AWT extends ApplicationFrame {
	private static final long serialVersionUID = 1L;
		Map< String,Float> map =  new LinkedHashMap< String,Float>();
	   public LineChart_AWT( String applicationTitle , String chartTitle, Map<String, Float> hm ) {
	      super(applicationTitle);
	      map = hm;
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Years","Average Marks",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }

	   public DefaultCategoryDataset createDataset( ) {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      Set< Map.Entry< String,Float> > st = map.entrySet();    
	       for (Entry<String, Float> me:st) 
	       { 
	           System.out.print(me.getKey()+":"); 
	           System.out.println(me.getValue()); 
	           dataset.addValue(me.getValue(), "marks" , me.getKey());
	       } 
	      return dataset;
	   }
	}