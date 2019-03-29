import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

public class TranscriberDemo {      
    
    public Boolean listening = false;
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
        String s = "", temp = "";
        // Start recognition process pruning previously cached data.
        recognizer.startRecognition(true);
    	SpeechResult result;
        while ((result = recognizer.getResult()) != null) 
        {
           temp = result.getHypothesis();    

           if( temp.contains("thank you"))
                break;            

           s = s + " " + temp; 
           System.out.format("Hypothesis: %s\n", s);

    	}
    	recognizer.stopRecognition();
        return s;
    }
}

