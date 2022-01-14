package com.threepillarglobal.craftsmanship.block;

import com.threepillarglobal.craftsmanship.Craftsmanship;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ThreePillarBlock extends Block {
    public static final Identifier ID = new Identifier(Craftsmanship.MOD_ID, "three_pillar_block");
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ThreePillarBlock() {
        super(FabricBlockSettings.of(Material.WOOD)
                .sounds(BlockSoundGroup.WOOD)
                .strength(2.5f)
                .breakByHand(false)
                .requiresTool());

        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}
