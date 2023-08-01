package com.teampotato.redirectionor.mixin.client;

import com.teampotato.redirectionor.references.GraphicsStatusReferences;
import net.minecraft.client.GraphicsStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GraphicsStatus.class)
public abstract class GraphicsStatusMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @SuppressWarnings("DataFlowIssue")
    @Overwrite
    public String toString() {
        return GraphicsStatusReferences.STRING_MAP.get((GraphicsStatus) (Object) this);
    }
}
