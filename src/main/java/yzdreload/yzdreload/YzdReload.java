package yzdreload.yzdreload;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class YzdReload extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        BukkitTask Message = new yzdreload.yzdreload.task.reload().runTaskTimer(this,0,600); //检测整点计时器
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
