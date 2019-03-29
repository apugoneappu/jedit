import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class TranscriberDemo {      
    
    public LiveSpeechRecognizer recognizer;
    
    public TranscriberDemo() throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

        recognizer = new LiveSpeechRecognizer(configuration);

    }
    
    public String SpeechToText() 
    {
        String s = " ";
        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
    	SpeechResult result;
        while ((result = recognizer.getResult()) != null) 
        {
	       s = s + " "+ result.getHypothesis();    
           System.out.format("Hypothesis: %s\n", s);
    	}
    	recognizer.stopRecognition();
        return s;
    }
}

