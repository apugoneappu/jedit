public class recognitionTest
{
	public String listenAndTell()
	{
		voce.SpeechInterface.init("../../../lib", false, true, "./grammar", "digits");

    String s = "";

    /*
		System.out.println("This is a speech recognition test. " 
			+ "Speak digits from 0-9 into the microphone. " 
			+ "Speak 'quit' to quit.");
      */

		boolean quit = false;
		while (!quit)
		{
			// Normally, applications would do application-specific things 
			// here.  For this sample, we'll just sleep for a little bit.
			try
			{
				Thread.sleep(200);
			}
			catch (InterruptedException e)
			{
        System.out.println(e);
			}

			while (voce.SpeechInterface.getRecognizerQueueSize() > 0)
			{
				 s = s + voce.SpeechInterface.popRecognizedString();

				// Check if the string contains 'quit'.
				if (-1 != s.indexOf("quit"))
				{
					quit = true;
				}

				System.out.println("You said: " + s);
				//voce.SpeechInterface.synthesize(s);
			}
		}

		voce.SpeechInterface.destroy();
    return s;
	}
}

