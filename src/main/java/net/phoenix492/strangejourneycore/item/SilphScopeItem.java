package net.phoenix492.strangejourneycore.item;

import net.phoenix492.strangejourneycore.registration.ModItems;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.entity.SpawnEvent;
import com.cobblemon.mod.common.api.reactive.ObservableSubscription;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoryItem;

public class SilphScopeItem extends AccessoryItem {
    public SilphScopeItem(Properties properties) {
        super(properties);
    }

    public static ObservableSubscription<SpawnEvent<PokemonEntity>> registerSpawnListener() {
        return CobblemonEvents.POKEMON_ENTITY_SPAWN.subscribe(Priority.NORMAL, event -> {
            Level level = event.getEntity().level();
            if (level.isClientSide()) {return;}
            ServerLevel serverLevel = (ServerLevel) level;
            List<Player> nearbyPlayers = serverLevel.getNearbyPlayers(
                TargetingConditions.forNonCombat().selector(entity -> {return true;}),
                event.getEntity(),
                event.getEntity().getBoundingBox().inflate(64)
            );
            boolean silphScopeEquippedPlayerNearby = false;
            for (Player p : nearbyPlayers) {
                if (AccessoriesCapability.get(p) instanceof AccessoriesCapability accCap) {
                    if (accCap.isEquipped(ModItems.SILPH_SCOPE.asItem())) {
                        silphScopeEquippedPlayerNearby = true;
                        break;
                    }
                }
            }

            if (!silphScopeEquippedPlayerNearby) {
                event.cancel();
            }
        });
    }
}