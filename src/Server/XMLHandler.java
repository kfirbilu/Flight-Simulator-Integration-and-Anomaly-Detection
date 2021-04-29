package Server;

import javafx.scene.control.ListView;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {

    public List<UserSettings> settingsList = new ArrayList<>();

    public AdditionalSettings additionalSettings = new AdditionalSettings();

    public boolean wrongFileFormat = false;

    public boolean missingArgument = false;

    public void getSettingsFromXML(String XMLFilePath )
    {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLFilePath)));
        } catch (FileNotFoundException e){ e.printStackTrace(); }
        for (int i = 0; i < 42; i++) {
            try {
                UserSettings decodedSettings = (UserSettings) decoder.readObject();
                settingsList.add(decodedSettings);

            } catch (NumberFormatException e)
            {
                if (!missingArgument )
                    wrongFileFormat = true;
                break;
            }
            catch (ArrayIndexOutOfBoundsException e){
                if (!missingArgument)
                    wrongFileFormat = true;
                break;
            }
            catch (ClassCastException e){
                if (!wrongFileFormat )
                    missingArgument = true;
                break;
            }
        }
        try {
            additionalSettings = (AdditionalSettings) decoder.readObject();

        } catch (NumberFormatException e)
        {
            if (!missingArgument)
                wrongFileFormat = true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            if (!missingArgument)
                wrongFileFormat = true;
        }
        catch (ClassCastException e){
            if (!wrongFileFormat )
                missingArgument = true;
        }

        for (UserSettings userSettings: settingsList)
        {
            if (userSettings.getRealColName() == null || userSettings.getColName() == null || userSettings.getMin() == -1000000 || userSettings.getMax() == 1000000 ) {
                if (!missingArgument )
                    wrongFileFormat = true;
                break;
            }
        }
        if (additionalSettings.getSampleRate() == 1000000 || additionalSettings.getCsvFile() == null || additionalSettings.algorithmFile == null)
            if (!missingArgument )
                wrongFileFormat = true;

        decoder.close();


    }


}
