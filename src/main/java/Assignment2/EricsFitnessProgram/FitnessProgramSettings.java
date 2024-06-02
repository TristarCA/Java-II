package Assignment2.EricsFitnessProgram;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(propOrder = {"name", "height", "weight", "birthday", "ftp"})
public class FitnessProgramSettings {
    private String name;
    private int height;
    private int weight;
    private LocalDate birthday;
    private float ftp;
    public FitnessProgramSettings() { }
    public FitnessProgramSettings(String name, int height, int weight, LocalDate birthday, float ftp) {
        setName(name);
        setHeight(height);
        setWeight(weight);
        setBirthday(birthday);
        setFtp(ftp);
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @XmlElement
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @XmlElement
    public float getFtp() {
        return ftp;
    }

    public void setFtp(float ftp) {
        this.ftp = ftp;
    }

    @XmlElement
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
