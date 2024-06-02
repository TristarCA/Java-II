package Assignment2.EricsFitnessProgram;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "settings")
public class Settings {
    @XmlElement(name = "userSettings")
    private List<FitnessProgramSettings> userSettings = new ArrayList<>();

    public List<FitnessProgramSettings> getSettings() {
        return userSettings;
    }

    public void setSettings(List<FitnessProgramSettings> settings) {
        this.userSettings = settings;
    }
}
