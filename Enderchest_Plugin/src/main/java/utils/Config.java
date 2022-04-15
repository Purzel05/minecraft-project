package utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

private static File file;
    private static YamlConfiguration configuration;

    public Config() {
        File dir = new File("./minecraft-project/Enderchest_Plugin/");
    if (!dir.exists()){
        dir.mkdirs();
    }

    file = new File(dir, "config.yml");
    if (!file.exists()){
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    configuration = YamlConfiguration.loadConfiguration(file);
    }
    public static boolean contains(String path){
    return configuration.contains(path);

    }
    public static void set(String path, Object value) throws IOException {
        configuration.set(path, value);

    }
    public static Object get(String path){
        if(!contains(path)){
            return null;
        }
          return configuration.get(path);
    }

}
