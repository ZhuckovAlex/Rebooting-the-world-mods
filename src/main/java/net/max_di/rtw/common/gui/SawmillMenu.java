package net.max_di.rtw.common.gui;

import com.google.common.collect.Lists;
import net.max_di.rtw.common.blocks.ModBlocksRW;
import net.max_di.rtw.common.recipes.ModRecipes;
import net.max_di.rtw.common.recipes.SawmillRecipe;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class SawmillMenu extends AbstractContainerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    private List<SawmillRecipe> recipes;
    private ItemStack input;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener;
    public final Container container;
    final ResultContainer resultContainer;

    public SawmillMenu(int p_40294_, Inventory p_40295_) {
        this(p_40294_, p_40295_, ContainerLevelAccess.NULL);
    }

    public SawmillMenu(int p_40297_, Inventory p_40298_, final ContainerLevelAccess p_40299_) {
        super(ModMenus.SAWMILL_MENU.get(), p_40297_);
        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = Lists.newArrayList();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {
        };
        this.container = new SimpleContainer(1) {
            public void setChanged() {
                super.setChanged();
                SawmillMenu.this.slotsChanged(this);
                SawmillMenu.this.slotUpdateListener.run();
            }
        };
        this.resultContainer = new ResultContainer();
        this.access = p_40299_;
        this.level = p_40298_.player.level();
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            public void onTake(Player p_150672_, ItemStack p_150673_) {
                p_150673_.onCraftedBy(p_150672_.level(), p_150672_, p_150673_.getCount());
                SawmillMenu.this.resultContainer.awardUsedRecipes(p_150672_, this.getRelevantItems());
                ItemStack inputStack = SawmillMenu.this.inputSlot.remove(1);
                if (!inputStack.isEmpty()) {
                    SawmillMenu.this.setupResultSlot();
                }

                p_40299_.execute((p_40364_, p_40365_) -> {
                    long time = p_40364_.getGameTime();
                    if (SawmillMenu.this.lastSoundTime != time) {
                        p_40364_.playSound((Player)null, p_40365_, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        SawmillMenu.this.lastSoundTime = time;
                    }
                });
                super.onTake(p_150672_, p_150673_);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(SawmillMenu.this.inputSlot.getItem());
            }
        });

        int $$5;
        for($$5 = 0; $$5 < 3; ++$$5) {
            for(int $$4 = 0; $$4 < 9; ++$$4) {
                this.addSlot(new Slot(p_40298_, $$4 + $$5 * 9 + 9, 8 + $$4 * 18, 84 + $$5 * 18));
            }
        }

        for($$5 = 0; $$5 < 9; ++$$5) {
            this.addSlot(new Slot(p_40298_, $$5, 8 + $$5 * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<SawmillRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player p_40307_) {
        return stillValid(this.access, p_40307_, ModBlocksRW.SAWMILL.get());
    }

    public boolean clickMenuButton(Player p_40309_, int p_40310_) {
        if (this.isValidRecipeIndex(p_40310_)) {
            this.selectedRecipeIndex.set(p_40310_);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int p_40335_) {
        return p_40335_ >= 0 && p_40335_ < this.recipes.size();
    }

    public void slotsChanged(Container p_40302_) {
        ItemStack $$1 = this.inputSlot.getItem();
        if (!$$1.is(this.input.getItem())) {
            this.input = $$1.copy();
            this.setupRecipeList(p_40302_, $$1);
        }

    }

    private void setupRecipeList(Container p_40304_, ItemStack p_40305_) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!p_40305_.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(ModRecipes.SAWMILL_TYPE.get(), p_40304_, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            SawmillRecipe $$0 = (SawmillRecipe)this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack $$1 = $$0.assemble(this.container, this.level.registryAccess());
            if ($$1.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed($$0);
                this.resultSlot.set($$1);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return ModMenus.SAWMILL_MENU.get();
    }

    public void registerUpdateListener(Runnable p_40324_) {
        this.slotUpdateListener = p_40324_;
    }

    public boolean canTakeItemForPickAll(ItemStack p_40321_, Slot p_40322_) {
        return p_40322_.container != this.resultContainer && super.canTakeItemForPickAll(p_40321_, p_40322_);
    }

    public ItemStack quickMoveStack(Player p_40328_, int p_40329_) {
        ItemStack $$2 = ItemStack.EMPTY;
        Slot $$3 = (Slot)this.slots.get(p_40329_);
        if ($$3 != null && $$3.hasItem()) {
            ItemStack $$4 = $$3.getItem();
            Item $$5 = $$4.getItem();
            $$2 = $$4.copy();
            if (p_40329_ == 1) {
                $$5.onCraftedBy($$4, p_40328_.level(), p_40328_);
                if (!this.moveItemStackTo($$4, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                $$3.onQuickCraft($$4, $$2);
            } else if (p_40329_ == 0) {
                if (!this.moveItemStackTo($$4, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ModRecipes.SAWMILL_TYPE.get(), new SimpleContainer(new ItemStack[]{$$4}), this.level).isPresent()) {
                if (!this.moveItemStackTo($$4, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 2 && p_40329_ < 29) {
                if (!this.moveItemStackTo($$4, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 29 && p_40329_ < 38 && !this.moveItemStackTo($$4, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if ($$4.isEmpty()) {
                $$3.setByPlayer(ItemStack.EMPTY);
            }

            $$3.setChanged();
            if ($$4.getCount() == $$2.getCount()) {
                return ItemStack.EMPTY;
            }

            $$3.onTake(p_40328_, $$4);
            this.broadcastChanges();
        }

        return $$2;
    }

    public void removed(Player p_40326_) {
        super.removed(p_40326_);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(p_40326_, this.container);
        });
    }
}
