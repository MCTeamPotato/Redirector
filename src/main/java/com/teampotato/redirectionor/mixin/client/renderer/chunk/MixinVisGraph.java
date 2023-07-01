package com.teampotato.redirectionor.mixin.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Set;

@Mixin(VisGraph.class)
public abstract class MixinVisGraph {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    private void addEdges(int pIndex, Set<Direction> pFaces) {
        int i = pIndex & 15;
        if (i == 0) {
            pFaces.add(Redirectionor.WEST);
        } else if (i == 15) {
            pFaces.add(Redirectionor.EAST);
        }
        int j = pIndex >> 8 & 15;
        if (j == 0) {
            pFaces.add(Redirectionor.DOWN);
        } else if (j == 15) {
            pFaces.add(Redirectionor.UP);
        }
        int k = pIndex >> 4 & 15;
        if (k == 0) {
            pFaces.add(Redirectionor.NORTH);
        } else if (k == 15) {
            pFaces.add(Redirectionor.SOUTH);
        }
    }
}
