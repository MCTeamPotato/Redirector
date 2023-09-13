package com.teampotato.redirector.mixin.net.minecraft.world.entity.animal;

import com.teampotato.redirector.utils.map.CommonMaps;
import net.minecraft.world.entity.animal.MushroomCow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MushroomCow.MushroomType.class)
public abstract class MushroomCowMushroomTypeMixin {
    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    private static MushroomCow.MushroomType byType(String name) {
        return CommonMaps.MUSHROOM_TYPE_NAME_MAP.getOrDefault(name, MushroomCow.MushroomType.RED);
    }
}
