package me.rekuseq.rekudrop;

import java.io.*;

public class ConfigManager {
    private final RekuDrop plugin;

    public ConfigManager(RekuDrop plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        generateConfig();
    }

    public void reloadConfig() {
        generateConfig();
        plugin.reloadConfig();
    }

    public void generateConfig() {
        File file = new File(plugin.getDataFolder() + File.separator + "config.yml");
        File folderFile = new File(plugin.getDataFolder().toString());
        if (!file.exists()) {
            if (!folderFile.isDirectory()) folderFile.mkdir();
            try (OutputStream outputStream = new FileOutputStream(file.toPath().toString())) {
                InputStream is = plugin.getResource("config.yml");
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                is.close();
            } catch (IOException e) {
                e.printStackTrace();

            }

        }
    }
}
