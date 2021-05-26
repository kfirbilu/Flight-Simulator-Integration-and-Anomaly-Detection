package Server;

import javafx.scene.control.ListView;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLHandler {

    public List<UserSettings> settingsList = new ArrayList<>();
    public Map <String, String> RealToAssosicate = new HashMap<>();
    public Map <String, String> AssosicateToReal = new HashMap<>();
    public Map <String, Integer> max = new HashMap<>();
    public Map<String, Integer> min = new HashMap<>();

    public AdditionalSettings additionalSettings = new AdditionalSettings();
    public boolean wrongFileFormat = false;
    public boolean missingArgument = false;



    public void getSettingsFromXML(String path) throws FileNotFoundException {
        XMLDecoder decoder = null;

        try {
            decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(path)));
        } catch (FileNotFoundException e){ e.printStackTrace(); }
        for (int i = 0; i < 11; i++) {
            try {
                UserSettings decodedSettings = (UserSettings) decoder.readObject();
                settingsList.add(decodedSettings);

            } catch (NumberFormatException e)
            {
                if (missingArgument == false)
                    wrongFileFormat = true;
                break;
            }
            catch (ArrayIndexOutOfBoundsException e){
                if (missingArgument == false)
                    wrongFileFormat = true;
                break;
            }
            catch (ClassCastException e){
                if (wrongFileFormat == false)
                    missingArgument = true;
                break;
            }
        }
        try {
            additionalSettings = (AdditionalSettings) decoder.readObject();

        } catch (NumberFormatException e)
        {
            if (missingArgument == false)
                wrongFileFormat = true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            if (missingArgument == false)
                wrongFileFormat = true;
        }
        catch (ClassCastException e){
            if (wrongFileFormat == false)
                missingArgument = true;
        }

        for (UserSettings userSettings: settingsList)
        {
            if (userSettings.getRealColName() == null || userSettings.getColName() == null || userSettings.getMin() == -1000000 || userSettings.getMax() == 1000000 ) {
                if (missingArgument == false)
                    wrongFileFormat = true;
                break;
            }
        }
        if (additionalSettings.getSampleRate() == 1000000 || additionalSettings.getCsvFile() == null || additionalSettings.algorithmFile == null) {
            if (missingArgument == false)
                wrongFileFormat = true;
        }
        for (UserSettings userSettings: settingsList)
        {
            RealToAssosicate.put(userSettings.getRealColName(), userSettings.getColName());
            AssosicateToReal.put(userSettings.getColName(), userSettings.getRealColName());
            max.put(userSettings.getRealColName(), userSettings.getMax());
            min.put(userSettings.getRealColName(), userSettings.getMin());
        }
        decoder.close();




    }


}
