import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class DataInputRepeatedlyAndContinuouslyFromDatasourceTests extends BaseTest {

    @Test
    public void testReadFromFile() {
        regLog.clickOnTermsAndConditionsAccept();
        regLog.clickOnRegisterTab();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("Datasource.txt"));
            String line = reader.readLine();

            int lineCounter = 0;
            while (line != null) { // ezzel meghatároztam a forrásfájl sorainak számát
                line = reader.readLine();
                lineCounter++;
            }
            System.out.println(lineCounter);

            String[] lineList = new String[lineCounter];
            for (int i = 0; i < lineList.length; i++) { // ezzel szeretném listába menteni forrásfájl sorait
                if (reader.readLine() != null) {
                    lineList[i] = reader.readLine();
                    System.out.println(Arrays.toString(lineList));
                }
            }

            // két for ciklus az adatok megfelelő inputba írásához?
            for (int i = 0; i < lineCounter; i++) {

                // hivatkoznom kellne a sorokra egyenként? Listába kellene rakni az egyes sorokat?
                for (int j = 0; j < 4; j++) {

                    // hivatkoznom kellene az egyes regisztrációkhoz szükséges blokkokra is?
                }
            }

            /*
            Scanner s = new Scanner(new File("Datasource.txt"));
            ArrayList<String> lines = new ArrayList<String>();
            while (s.hasNextLine()){
                System.out.println(lines);
            }
            s.close();
            */

            /*
            while (line != null) {
                regLog.fillRegisterUsername(line);
                regLog.fillRegisterPassword(line);
                regLog.fillRegisterEmail(line);
                regLog.fillRegisterDescription(line);
                //Thread.sleep(2000);
                line = reader.readLine();
            }

             */
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Assertions.assertEquals();
    }

}
