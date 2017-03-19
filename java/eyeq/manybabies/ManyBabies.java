package eyeq.manybabies;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import eyeq.manybabies.event.ManyBabiesEventHandler;

import static eyeq.manybabies.ManyBabies.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
public class ManyBabies {
    public static final String MOD_ID = "eyeq_manybabies";

    @Mod.Instance(MOD_ID)
    public static ManyBabies instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ManyBabiesEventHandler());
    }
}
