package de.lulonaut.hotbarbinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "hotbarbinds", name = "HotbarBinds", version = "1.0")
public class HotbarBinds {

    public static KeyBinding[] hotbarKeyBindings = new KeyBinding[]{new KeyBinding("Slot 1", 2, "hotbarbinds"), new KeyBinding("Slot 2", 3, "hotbarbinds"), new KeyBinding("Slot 3", 4, "hotbarbinds"), new KeyBinding("Slot 4", 5, "hotbarbinds"), new KeyBinding("Slot 5", 6, "hotbarbinds"), new KeyBinding("Slot 6", 7, "hotbarbinds"), new KeyBinding("Slot 7", 8, "hotbarbinds"), new KeyBinding("Slot 8", 9, "hotbarbinds"), new KeyBinding("Slot 9", 10, "hotbarbinds")};

    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        for (KeyBinding hotbarKeyBinding : hotbarKeyBindings) {
            ClientRegistry.registerKeyBinding(hotbarKeyBinding);
        }

        MinecraftForge.EVENT_BUS.register(new BindingListener());
    }
}
