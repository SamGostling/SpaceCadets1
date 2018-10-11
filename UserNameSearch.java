import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
public class UserNameSearch {

    public static String GetInput() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Input String:");
        String Input = br.readLine();
        br.close();
        return Input;
    }

    public static void main(String[] args) throws IOException{
        URL myURL = new URL("https://www.ecs.soton.ac.uk/people/" + GetInput());

        BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
        String line;
        Boolean found = false;
        while (((line = in.readLine()) != null) & !found) {
            if (line.indexOf("property=\"name\">") != -1 ){
                found = true;
                int first = (line.indexOf("\"name\""))+7;
                int last = line.indexOf("</h1><h2 class");
                System.out.println(line.substring(first, last));
            }
        }
        in.close();
    }
}
