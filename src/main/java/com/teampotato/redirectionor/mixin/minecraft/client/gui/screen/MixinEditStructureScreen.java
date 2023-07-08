package com.teampotato.redirectionor.mixin.minecraft.client.gui.screen;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.gui.screen.EditStructureScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.tileentity.StructureBlockTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EditStructureScreen.class)
public abstract class MixinEditStructureScreen extends Screen {
    @Shadow @Final private StructureBlockTileEntity structure;
    @Shadow protected abstract void updateMirrorButton();
    @Shadow protected abstract void updateDirectionButtons();
    protected MixinEditStructureScreen(ITextComponent pTitle) {
        super(pTitle);
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/EditStructureScreen;addButton(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 7))
    private Widget onInitAddButton7(EditStructureScreen instance, Widget widget) {
        return this.addButton(new Button(this.width / 2 - 20, 185, 40, 20, new StringTextComponent("MIRROR"), (button) -> {
            switch(this.structure.getMirror().toString()) {
                case "NONE":
                    this.structure.setMirror(Redirectionor.LEFT_RIGHT);
                    break;
                case "LEFT_RIGHT":
                    this.structure.setMirror(Redirectionor.FRONT_BACK);
                    break;
                case "FRONT_BACK":
                    this.structure.setMirror(Redirectionor.MIRROR_NONE);
            }

            this.updateMirrorButton();
        }));
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/EditStructureScreen;addButton(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 10))
    private Widget onInitAddButton10(EditStructureScreen instance, Widget widget) {
        return this.addButton(new Button(this.width / 2 - 1 - 40 - 1 - 40 - 20, 185, 40, 20, new StringTextComponent("0"), (button) -> {
            this.structure.setRotation(Redirectionor.NONE);
            this.updateDirectionButtons();
        }));
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/EditStructureScreen;addButton(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 11))
    private Widget onInitAddButton11(EditStructureScreen instance, Widget widget) {
        return this.addButton(new Button(this.width / 2 - 1 - 40 - 20, 185, 40, 20, new StringTextComponent("90"), (button) -> {
            this.structure.setRotation(Redirectionor.CLOCKWISE_90);
            this.updateDirectionButtons();
        }));
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/EditStructureScreen;addButton(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 12))
    private Widget onInitAddButton12(EditStructureScreen instance, Widget widget) {
        return this.addButton(new Button(this.width / 2 + 1 + 20, 185, 40, 20, new StringTextComponent("180"), (button) -> {
            this.structure.setRotation(Redirectionor.CLOCKWISE_180);
            this.updateDirectionButtons();
        }));
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/EditStructureScreen;addButton(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;", ordinal = 13))
    private Widget onInitAddButton13(EditStructureScreen instance, Widget widget) {
        return this.addButton(new Button(this.width / 2 + 1 + 40 + 1 + 20, 185, 40, 20, new StringTextComponent("270"), (button) -> {
            this.structure.setRotation(Redirectionor.COUNTERCLOCKWISE_90);
            this.updateDirectionButtons();
        }));
    }
}
