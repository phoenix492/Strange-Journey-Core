package net.phoenix492.strangejourneycore.listeners;

import net.phoenix492.strangejourneycore.core.StrangeJourneyCore;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import org.dimdev.dimdoors.DimensionalDoors;

@EventBusSubscriber(modid = StrangeJourneyCore.MODID)
public class LimboVoidTeleport {
    @SubscribeEvent
    public static void damageEvent(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        Player player;
        if (!(entity instanceof Player) || !event.getSource().is(DamageTypes.FELL_OUT_OF_WORLD) || ((Player) entity).isFakePlayer()) {
            return;
        } else {
            player = (Player) entity;
        }
        org.dimdev.dimdoors.api.util.TeleportUtil.teleport(player, DimensionalDoors.getWorld(org.dimdev.dimdoors.world.ModDimensions.LIMBO), new Vec3(player.position().x, 400, player.position().z), player.getVisualRotationYInDegrees());
        player.awardStat(org.dimdev.dimdoors.entity.stat.ModStats.TIMES_SENT_TO_LIMBO);
        event.setCanceled(true);
    }
}
