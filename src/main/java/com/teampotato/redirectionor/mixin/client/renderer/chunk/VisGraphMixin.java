package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Set;

@Mixin(value = VisGraph.class, priority = 10)
public abstract class VisGraphMixin {

    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void addEdges(int pPos, Set<Direction> pSetFacings) {
        int i = pPos & 15;
        if (i == 0) {
            pSetFacings.add(Redirectionor.WEST);
        } else if (i == 15) {
            pSetFacings.add(Redirectionor.EAST);
        }

        int j = pPos >> 8 & 15;
        if (j == 0) {
            pSetFacings.add(Redirectionor.DOWN);
        } else if (j == 15) {
            pSetFacings.add(Redirectionor.UP);
        }

        int k = pPos >> 4 & 15;
        if (k == 0) {
            pSetFacings.add(Redirectionor.NORTH);
        } else if (k == 15) {
            pSetFacings.add(Redirectionor.SOUTH);
        }

    }
}
