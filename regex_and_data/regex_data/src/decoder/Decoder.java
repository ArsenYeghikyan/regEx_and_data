package decoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {


    public String getString(String str) {
        String s = "";
        if (str != null) {
            Pattern p = Pattern.compile("(?<!\\S)(?:из|под|из-за|из-под|это|как|так|и|в|над|к|до|не|на|но|за|то|с|ли|а|во|от|со|для|о|же|ну|вы|бы|что|кто|он|она)(?!\\S)", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

            Matcher m = p.matcher(str);

            while (m.find()) {
                s = m.replaceAll("Java");
            }
        }


        return s;
    }


    public void decode() {

        File fileBeforeDecode = new File("regex_data/src/file_before_decode.txt");
        File fileAfterDecode = new File("regex_data/src/file_after_decode.txt");


        try (BufferedReader br = new BufferedReader(new FileReader(fileBeforeDecode));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileAfterDecode))) {

            String line;

            while ((line = br.readLine()) != null) {

                bw.write(getString(line));
                bw.flush();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
