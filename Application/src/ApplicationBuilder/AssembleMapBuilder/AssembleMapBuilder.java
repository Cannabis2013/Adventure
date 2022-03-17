package ApplicationBuilder.AssembleMapBuilder;

import ApplicationBuilder.AssembleMapBuilder.Contracts.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildMap;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.BuildRooms;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.Repositories.OrdinaryMapDescriptions;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.Repositories.SpecialMapDescriptions;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.UpdateRoomDescriptions;

public class AssembleMapBuilder {

    IUpdateRoomDescriptor assembleOrdinaryDescriptor(){
        var descriptor = new UpdateRoomDescriptions();
        descriptor.setRepository(new OrdinaryMapDescriptions());
        return descriptor;
    }

    IUpdateRoomDescriptor assembleSpecialDescriptor(){
        var descriptor = new UpdateRoomDescriptions();
        descriptor.setRepository(new SpecialMapDescriptions());
        return descriptor;
    }

    public BuildMap assemble(){
        var builder = new BuildMap();
        builder.setRoomBuilder(new BuildRooms());
        builder.setUpdateRoomDescriptions(assembleOrdinaryDescriptor());
        builder.setUpdateSpecialRoomDescriptions(assembleSpecialDescriptor());
        return builder;
    }
}
