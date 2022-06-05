package de.lulonaut.hotbarbinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod(modid = "hotbarbinds", name = "HotbarBinds", version = "1.0")
public class HotbarBinds {

    KeyBinding[] hotbarKeyBindings = new KeyBinding[]{
            new KeyBinding("Slot 1", 2, "hotbarbinds"),
            new KeyBinding("Slot 2", 3, "hotbarbinds"),
            new KeyBinding("Slot 3", 4, "hotbarbinds"),
            new KeyBinding("Slot 4", 5, "hotbarbinds"),
            new KeyBinding("Slot 5", 6, "hotbarbinds"),
            new KeyBinding("Slot 6", 7, "hotbarbinds"),
            new KeyBinding("Slot 7", 8, "hotbarbinds"),
            new KeyBinding("Slot 8", 9, "hotbarbinds"),
            new KeyBinding("Slot 9", 10, "hotbarbinds")
    };

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        for (KeyBinding hotbarKeyBinding : hotbarKeyBindings) {
            ClientRegistry.registerKeyBinding(hotbarKeyBinding);
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().thePlayer == null) return;

        for (int i = 0; i < 9; i++) {
            if (hotbarKeyBindings[i].isPressed()) {
                Minecraft.getMinecraft().thePlayer.inventory.currentItem = i;
                break;
            }
        }
    }
}
