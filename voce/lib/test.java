import com.sun.speech.freetts.*;
public class test
{
    public static void main(String arg[]) throws Exception {

        Voice v = VoiceManager.getInstance().getVoice("kevin16");
        v.allocate();
        v.setPitch(150.0F); //Optional – set pitch for the voice
        v.setVolume(1.0F); //Optional – set volume of output 0 to 1
        v.setRate(160.0F); // Optional – set words spoken per minute
        String s = "Hello "+System.getProperty("user.name")+"!\n"+ "I am kevin speaking at 16 kHz!\nWill you take me as your friend?";
        v.speak(s);

        System.exit(0);
    }
}
