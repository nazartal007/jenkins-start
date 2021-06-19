package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void readNullFromProperty(){
        String value = System.getProperty("привет");

        System.out.println(value);
    }

    @Test
    void SetAndReadFromProperties(){
        System.setProperty("привет", "медвед");
        String value = System.getProperty("привет");

        System.out.println(value);
    }

    @Test
    void ReadDefaultFromProperties(){
        String value = System.getProperty("привет", "Дефолт");

        System.out.println(value);
    }

    @Test
    void ReadWithGradleFromProperties(){
        String value = System.getProperty("browser", "Дефолт");

        System.out.println(value);
    }

    @Test
    @Tag("terminal")
    void ReadWithTerminalFromProperties(){
        String version = System.getProperty("version", "91");
        String browser = System.getProperty("browser", "opera");

        System.out.println(version);
        System.out.println(browser);
    }
}
