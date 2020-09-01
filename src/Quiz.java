import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Quiz {

    public static void main(String[] args) throws Exception {

        if(null == args[0]){
            throw new IllegalArgumentException();
        }

        File file = new File(".");
        // List Files
//        for(String fileNames : file.list()) System.out.println(fileNames);

        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();

        while(line!=null){
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
