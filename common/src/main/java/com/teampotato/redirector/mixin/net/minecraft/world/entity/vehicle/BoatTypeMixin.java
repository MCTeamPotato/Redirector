package com.teampotato.redirector.mixin.net.minecraft.world.entity.vehicle;

import com.teampotato.redirector.utils.map.CommonMaps;
import com.teampotato.redirector.utils.values.CommonValues;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Boat.Type.class)
public abstract class BoatTypeMixin {
    /**
     * @author Kasualix
     * @reason avoid allocation
     */
    @Overwrite
    public static Boat.Type byId(int id) {
        Boat.Type[] types = CommonValues.BOAT_TYPES;
        if (id < 0 || id >= types.length) id = 0;
        return types[id];
    }

    /**
     * @author Kasualix
     * @reason use faster map impl
     */
    @Overwrite
    public static Boat.Type byName(String name) {
        return CommonMaps.BOAT_TYPE_NAME_MAP.getOrDefault(name, CommonValues.BOAT_TYPES[0]);
    }
}
