import java.io.BufferedReader;
import java.io.InputStreamReader;

public class synthesisTest
{
	public synthesisTest()
	{
		voce.SpeechInterface.init("../../../lib", true, false, "", "");
  }

  public void read(String s)
  {
		try
		{
				voce.SpeechInterface.synthesize(s);
    }
		catch (Exception e)
		{
			System.out.println( "Error:" + e);
		}
	}
}

