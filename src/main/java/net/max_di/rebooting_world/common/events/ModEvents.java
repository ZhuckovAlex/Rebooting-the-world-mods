package net.max_di.rebooting_world.common.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.max_di.rebooting_world.RTW;
import net.max_di.rebooting_world.common.items.ModItemsRW;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = RTW.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10+pRandom.nextInt(10)),
                    new ItemStack(ModItemsRW.REPAIR_TEMPLATE.get()),
                    3, 1, 0.2f));
        }
        if(event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10+pRandom.nextInt(10)),
                    new ItemStack(ModItemsRW.REPAIR_TEMPLATE.get()),
                    3, 1, 0.2f));
        }
        if(event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10+pRandom.nextInt(10)),
                    new ItemStack(ModItemsRW.REPAIR_TEMPLATE.get()),
                    3, 1, 0.2f));
        }
    }
}
