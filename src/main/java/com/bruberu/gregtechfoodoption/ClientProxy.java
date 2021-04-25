package com.bruberu.gregtechfoodoption;

import codechicken.lib.util.ItemNBTUtils;
import com.bruberu.gregtechfoodoption.item.GTFOOredictItem;
import com.bruberu.gregtechfoodoption.utils.GTFOLog;
import gregicadditions.item.GADustItem;
import gregicadditions.materials.SimpleDustMaterial;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.Optional;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {


    @Override
    public void preLoad() {
        super.preLoad();
        if (!Minecraft.getMinecraft().getFramebuffer().isStencilEnabled()) {
            Minecraft.getMinecraft().getFramebuffer().enableStencil();
        }
        GTFOLog.logger.info(Minecraft.getMinecraft().getFramebuffer().isStencilEnabled());
    }


    @Override
    public void onLoad() throws IOException {
        super.onLoad();
    }


    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }
    @SubscribeEvent
    public static void addFormulaHandler(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        if (itemStack.getItem() instanceof GTFOOredictItem.OreDictItem) {
            GTFOOredictItem.OreDictItem oredictItem = (GTFOOredictItem.OreDictItem) itemStack.getItem();
            String formula = oredictItem.getFormula();
            if (formula != null && !formula.isEmpty() && event.getToolTip().size() == 0) {
                event.getToolTip().add(1, TextFormatting.GRAY.toString() + formula);
            }
        }
    }
}
