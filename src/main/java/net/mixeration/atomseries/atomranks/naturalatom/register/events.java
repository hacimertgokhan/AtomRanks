package net.mixeration.atomseries.atomranks.naturalatom.register;

import net.mixeration.atomseries.atomranks.AtomRanks;
import net.mixeration.atomseries.atomranks.storage.player;

import static net.mixeration.atomseries.atomranks.AtomRanks.manager;

public class events {

    public static void regEvents() {
        manager.registerEvents(new player(AtomRanks.getInstance()), AtomRanks.getInstance());
    }

}
