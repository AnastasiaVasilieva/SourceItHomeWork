import java.io.*;

/**
 * Created by Nastya on 08.06.2016.
 */
public class HW {
    private static String text = "An array type is written as the name of " +
            "an element type followed by some number of empty pairs of square " +
            "brackets []. The number of bracket pairs indicates the depth of array nesting.";
    private static String fileName = "ex16/src/test.txt";
    public static void main(String[] args) throws IOException {
        create(fileName,text);
        System.out.println(readString(fileName));
        System.out.println(readByte());

    }

    public static void create (String fileName, String text) throws IOException{
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readString(String fileName) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        file.exists();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s);
                }
            } finally {
                bufferedReader.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
    public static String readByte()throws IOException{
        InputStream is = new FileInputStream("ex16/src/test.txt");
        byte[] temp = new byte[is.available()];
        is.read(temp);
        return new String(temp);
    }


}

