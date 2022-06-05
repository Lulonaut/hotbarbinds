package de.lulonaut.hotbarbinds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class BindingListener {

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().thePlayer == null) return;

        for (int i = 0; i < 9; i++) {
            if (HotbarBinds.hotbarKeyBindings[i].isPressed()) {
                Minecraft.getMinecraft().thePlayer.inventory.currentItem = i;
                break;
            }
        }
    }
}
