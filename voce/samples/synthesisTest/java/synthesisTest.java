import java.io.BufferedReader;
import java.io.InputStreamReader;

/// A sample application showing how to use Voce's speech synthesis 
/// capabilities.

public class synthesisTest
{
	public synthesisTest()
	{
		voce.SpeechInterface.init("../../../lib", true, false, "", "");
		//voce.SpeechInterface.synthesize("This is a speech synthesis test.");
		System.out.println("Enter text to be spoken");
  }

  public void speakString(String s)
		try
		{
				voce.SpeechInterface.synthesize(s);
    }
		catch (java.io.IOException ioe)
		{
			System.out.println( "IO error:" + ioe );
		}
	}
}

