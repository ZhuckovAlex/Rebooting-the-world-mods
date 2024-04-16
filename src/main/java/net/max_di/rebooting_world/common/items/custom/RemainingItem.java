package net.max_di.rebooting_world.common.items.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RemainingItem extends Item {
    public RemainingItem(Properties properties) {
        super(properties);
    }
    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }
}
