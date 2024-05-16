package net.davebalda.pacocraft.sound;

import net.davebalda.pacocraft.PacoCraft;
import net.minecraft.client.sound.Sound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    //--- <MOD SOUND LIST> ----//
    public static final SoundEvent CHECHNYA = registerSoundEvent("chechnya");
    public static final SoundEvent FACCETTA_NERA = registerSoundEvent("faccetta_nera");
    public static final SoundEvent ABOMINEM_AMBIENT = registerSoundEvent("abominem_ambient");
    public static final SoundEvent ABOMINEM_ALERT = registerSoundEvent("abominem_alert");
    public static final SoundEvent ABOMINEM_DEATH = registerSoundEvent("abominem_death");
    public static final SoundEvent ABOMINEM_HURT = registerSoundEvent("abominem_hurt");


    //---- <METHODS> ----//
    private static SoundEvent registerSoundEvent(String name){
        Identifier ID = new Identifier(PacoCraft.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, ID, SoundEvent.of(ID));
    }

    public static void registerSounds(){
        PacoCraft.LOGGER.info("Registering Mod Sounds for: " + PacoCraft.MOD_ID);
    }

}
