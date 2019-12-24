package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class stopDocker {

	@Test
	public void ShutDownDocker() throws IOException, InterruptedException
	{
		boolean flag=false;
		Runtime runTime=Runtime.getRuntime();
		runTime.exec("cmd /c start dockerDown.bat");
		
		String fileName="DockerGridLog.txt";
		
		// Gets Current Time and stores the time 30 seconds ahead.
		Calendar time=Calendar.getInstance();
		time.add(Calendar.SECOND, 45); // change number amount of seconds ahead.
		long stopTime=time.getTimeInMillis();
		Thread.sleep(3000);
		
		while(System.currentTimeMillis()<stopTime)
		{
			if(flag)
			{
				break;
			}
			BufferedReader reader=new BufferedReader(new FileReader(fileName));
			String currentLine=reader.readLine();
			
			while(currentLine!=null && !flag)
			{
				if (currentLine.contains("selenium-hub exited"))
				{
					System.out.println("Found it.");
					flag=true;
					break;
				}
			 currentLine=reader.readLine();
			}
		  reader.close();
		}
		
		Assert.assertTrue(flag);
//		File fileDel=new File(fileName);
//		if (fileDel.delete())
//		{
//			System.out.println("file deleted");
//		}
		
	}
}
