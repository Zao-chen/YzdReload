package yzdreload.yzdreload.task;


import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class reload extends BukkitRunnable {
    @Override
    /*新线程执行*/
    public void run()
    {
        Plugin config = yzdreload.yzdreload.YzdReload.getProvidingPlugin(yzdreload.yzdreload.YzdReload.class); //获取配置文件
        SimpleDateFormat formatter= new SimpleDateFormat("mm"); //获取时间戳并格式化
        Date date = new Date(System.currentTimeMillis());
        /*检测有没有重启过*/
        if(formatter.format(date).equals("58")) //重启提示
        {
            Bukkit.broadcastMessage("§7§l[§6重启系统§7§l] §r服务器将在两分钟后重启，请确保你处在安全区域");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"qq say 服务器将在两分钟后重启"); //q群提示
            config.getConfig().set("have-reloaded",false); //设置为未重启过
        }
        else if(formatter.format(date).equals("59")) //重启提示
        {
            Bukkit.broadcastMessage("§7§l[§6重启系统§7§l] §r服务器将在一分钟后重启，请确保你处在安全区域");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"qq say 服务器将在一分钟后重启"); //q群提示
            config.getConfig().set("have-reloaded",false); //设置为未重启过
        }
        else if(formatter.format(date).equals("01"))
        {
            config.getConfig().set("have-reloaded",false); //设置为未重启过
        }
        else if(formatter.format(date).equals("02"))
        {
            config.getConfig().set("have-reloaded",false); //设置为未重启过
        }
        /*保存并重载配置文件*/
        config.saveConfig();
        config.reloadConfig();

        if(formatter.format(date).equals("00")&&!config.getConfig().getBoolean("have-reloaded")) //如果发现是整点
        {
            Bukkit.broadcastMessage("§7§l[§6重启系统§7§l] §r服务器正在重启");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"qq say 服务器正在重启"); //q群提示
            config.getConfig().set("have-reloaded",true); //设置为已重启过
            config.saveConfig();
            config.reloadConfig();
            Bukkit.reload();
        }
    }
}