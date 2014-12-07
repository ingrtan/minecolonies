package com.minecolonies.colony.buildings;

import com.blockout.views.Window;
import com.minecolonies.client.gui.WindowHutBuilder;
import com.minecolonies.colony.Colony;
import com.minecolonies.colony.ColonyView;
import com.minecolonies.entity.EntityBuilder;
import com.minecolonies.entity.EntityCitizen;
import com.minecolonies.entity.EntityWorker;
import com.minecolonies.entity.jobs.ColonyJob;
import com.minecolonies.entity.jobs.JobBuilder;
import com.minecolonies.lib.EnumGUI;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class BuildingBuilder extends BuildingWorker
{
    public BuildingBuilder(Colony c, ChunkCoordinates l)
    {
        super(c, l);
    }

    @Override
    public String getSchematicName() { return "Builder"; }

    @Override
    public String getJobName() { return "Builder"; }

    //  Classic Style of Jobs
    @Override
    public EntityWorker createWorker(World world) { return new EntityBuilder(world); }

    //  Future Style of Jobs
    @Override
    public Class<JobBuilder> getJobClass() { return JobBuilder.class; }
    @Override
    public ColonyJob createJob(EntityCitizen citizen) { return new JobBuilder(citizen); }

    @Override
    public int getGuiId() { return EnumGUI.BUILDER.getID(); }

    public static class View extends BuildingWorker.View
    {
        public View(ColonyView c, ChunkCoordinates l)
        {
            super(c, l);
        }

        public Window getWindow(int guiId)
        {
            if (guiId == EnumGUI.BUILDER.getID())
            {
                return new WindowHutBuilder(this);
            }

            return null;
        }
    }
}
