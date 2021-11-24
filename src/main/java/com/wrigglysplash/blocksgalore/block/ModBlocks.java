package com.wrigglysplash.blocksgalore.block;

import com.wrigglysplash.blocksgalore.BlocksGalore;
import com.wrigglysplash.blocksgalore.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BlocksGalore.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlocks("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(8)));
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlocks("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3)));


    private static <T extends Block>RegistryObject<T> registerBlocks(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
