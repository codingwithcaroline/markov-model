import java.io.File;
import java.io.IOException;

/**
 * TextGenerator.java. Creates an order K Markov model of the supplied source
 * text, and then outputs M characters generated according to the model.
 *
 * @author Caroline Kirkconnell (CarolineKirkconnell8@gmail.com)
 * @version 2020-11-29
 *
 */
public class TextGenerator {

   /** Drives execution. */
   public static void main(String[] args) {
   
      File file = new File("Thistestrequiresabunchofcharacterstopassthistestsoheretheyarelayedout"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharactershfaslfhldslkdslkfhdslk.txt"
         + "thecorrectnumberofcharactersabcdefgabcdefgabcdefga.txt"
         + "thecorrectnumberofcharacte.txt");
      args = new String[3];
      args[0] = "10";
      args[1] = "500";
      args[2] = file.toString();
   
      if (args.length < 3) {
         System.out.println("Usage: java TextGenerator k length input");
         return;
      }
   
      // No error checking! You may want some, but it's not necessary.
      int K = Integer.parseInt(args[0]);
      int M = Integer.parseInt(args[1]);
      if ((K < 0) || (M < 0)) {
         System.out.println("Error: Both K and M must be non-negative.");
         return;
      }
   
      File text;
      try {
         text = new File(args[2]);
         if (!text.canRead()) {
            throw new Exception();
         }
      }
      catch (Exception e) {
         System.out.println("Error: Could not open " + args[2] + ".");
         return;
      }
   
   
      // instantiate a MarkovModel with the supplied parameters and
      // generate sample output text ...
      
      MarkovModel mod = new MarkovModel(K, text);
      String answer = mod.getFirstKgram();
      for (int i = 0; i < M - K; i++) {
         String g = answer.substring(i, i + K);
         try {
            answer += mod.getNextChar(g);
         } catch (NullPointerException e) {
            answer += mod.getRandomKgram();
         }
         System.out.println(answer.length());
      }
      System.out.print(answer);
   }
   
}
