package playerlightlevelfix.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import playerlightlevelfix.MatrixLighting;

@Mixin(InventoryScreen.class)
public class InventoryScreenPushMixin {
	@Inject(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;pushMatrix()V", shift = At.Shift.AFTER, ordinal = 0), method = "drawEntity")
	private static void fixDrawEntityLighting(int x, int y, int size, float mouseX, float mouseY, LivingEntity entity, CallbackInfo ci) {
		on();
	}

	@Unique
	private static void on() {
		RenderSystem.assertThread(RenderSystem::isOnRenderThread);
		RenderSystem.setupLevelDiffuseLighting(MatrixLighting.getOn());
	}
}
