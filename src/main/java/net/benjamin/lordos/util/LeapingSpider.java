package net.benjamin.lordos.util;

import net.benjamin.lordos.Lordos;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class LeapingSpider implements Listener {

    static Lordos plugin;

    public LeapingSpider(Lordos plugin){
        this.plugin = plugin;
    }

    public static void  createLeapingSpider(Location location){
        Spider spider = location.getWorld().spawn(location, Spider.class);
        spider.setCustomName(ChatColor.DARK_RED + "Leaping Spider");
        spider.setCustomNameVisible(true);
        Attributable spiderAt = spider;
        AttributeInstance attribute = spiderAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(150);
        spider.setHealth(150);
        spider.damage(25);


        new BukkitRunnable(){
            @Override
            public void run() {
                if(!spider.isDead()) {
                    if(spider.getTarget() == null){
                        for(Entity entity : spider.getNearbyEntities(10, 10, 10)){
                            if(entity instanceof Player){
                                Player player = (Player) entity;
                                spider.setTarget(player);
                            }
                        }
                    }
                    else{
                        LivingEntity target = spider.getTarget();
                        if(target.getLocation().distanceSquared(spider.getLocation()) > 25){
                            spider.getWorld().playSound(spider.getLocation(), Sound.ENTITY_WITHER_SHOOT, 5, 5);
                            spider.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, spider.getLocation(), 10);
                            spider.setVelocity(target.getLocation().add(0, 2, 0).subtract(spider.getLocation()).toVector().multiply(0.275));

                        }
                    }
                    }
                else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin,0L, 20L);
    }
    }

