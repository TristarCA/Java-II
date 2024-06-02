package Assignment2.EricsFitnessProgram;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "height", "weight", "year", "month", "day", "ftp"})
public class FitnessProgramSettings {
    private static final String DEFAULT_NAME = "User";
    private static final int DEFAULT_HEIGHT = 100;
    private static final int DEFAULT_WEIGHT = 100;
    private static final int DEFAULT_YEAR = 1980;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_DAY = 1;
    private static final float DEFAULT_FTP = 1.0f;

    private String name;
    private int height;
    private int weight;
    private int year;
    private int month;
    private int day;
    private float ftp;

    public FitnessProgramSettings() {
        this(DEFAULT_NAME, DEFAULT_HEIGHT, DEFAULT_WEIGHT, DEFAULT_YEAR, DEFAULT_MONTH, DEFAULT_DAY, DEFAULT_FTP);
    }

    public FitnessProgramSettings(String name, int height, int weight, int year, int month, int day, float ftp) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.year = year;
        this.month = month;
        this.day = day;
        this.ftp = ftp;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null && !name.isEmpty() ? name : DEFAULT_NAME;
    }

    @XmlElement
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height > 0 ? height : DEFAULT_HEIGHT;
    }

    @XmlElement
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight > 0 ? weight : DEFAULT_WEIGHT;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = (year >= 1900 && year <= 2100) ? year : DEFAULT_YEAR;
    }

    @XmlElement
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : DEFAULT_MONTH;
    }

    @XmlElement
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = (day >= 1 && day <= 31) ? day : DEFAULT_DAY;
    }

    @XmlElement
    public float getFtp() {
        return ftp;
    }

    public void setFtp(float ftp) {
        this.ftp = ftp > 0 ? ftp : DEFAULT_FTP;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Height: " + height + " cm\n" +
                "Weight: " + weight + " lbs\n" +
                "Birthday: " + year + "/"  + month + "/" + day + "\n" +
                "FTP: " + ftp;
    }
}