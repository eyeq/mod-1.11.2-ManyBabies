package eyeq.manybabies.event;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.*;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class ManyBabiesEventHandler {
    @SubscribeEvent
    public void onEntityBorned(BabyEntitySpawnEvent event) {
        EntityAgeable entity = event.getChild();
        World world = entity.getEntityWorld();
        if(world.isRemote) {
            return;
        }
        if(!(event.getParentA() instanceof EntityAnimal) || !(event.getParentB() instanceof EntityAnimal)) {
            return;
        }
        EntityAnimal mother = (EntityAnimal) event.getParentA();
        EntityAnimal father = (EntityAnimal) event.getParentB();
        int n = getBabyNum(entity);
        for(int i = 0; i < n; i++) {
            EntityAgeable child = mother.createChild(father);
            if(child == null) {
                return;
            }
            child.setGrowingAge(-24000);
            child.setPositionAndRotation(mother.posX, mother.posY, mother.posZ, 0.0F, 0.0F);
            world.spawnEntity(child);
        }
    }

    private int getBabyNum(EntityLivingBase entity) {
        Random rand = entity.getRNG();
        if(entity instanceof EntityChicken) {
            if(rand.nextInt(32) == 0) {
                return 3;
            }
            return 0;
        }
        if(entity instanceof EntityLlama) {
            if(rand.nextInt(1000000) == 0) {
                return 1;
            }
            return 0;
        }
        if(entity instanceof EntityCow) {
            if(rand.nextInt(1000000) == 0) {
                return  1;
            }
            return 0;
        }
        if(entity instanceof EntityHorse) {
            if(rand.nextInt(10000) == 0) {
                return 1;
            }
            return 0;
        }
        if(entity instanceof EntitySheep) {
            if(rand.nextInt(3) == 0) {
                return 1;
            }
            return 0;
        }

        if(entity instanceof EntityPig) {
            return 8 + rand.nextInt(6);
        }
        if(entity instanceof EntityWolf) {
            return 2 + rand.nextInt(11);
        }
        if(entity instanceof EntityOcelot) {
            return rand.nextInt(7);
        }
        if(entity instanceof EntityRabbit) {
            return rand.nextInt(7);
        }
        if(entity instanceof EntityPolarBear) {
            return rand.nextInt(2);
        }
        return 0;
    }
}
