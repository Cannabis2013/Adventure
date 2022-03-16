package ApplicationBuilder.AssembleMapBuilder;

import Application.BuildMap.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildMap;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.BuildRooms;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.Repositories.OrdinaryMapDescriptions;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.Repositories.SpecialMapDescriptions;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization.UpdateRoomDescriptions;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.RoomConnector.ConnectRegularRooms;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.RoomConnector.ConnectSpecialRoom;

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
        builder.setConnectRegularRooms(new ConnectRegularRooms());
        builder.setConnectSpecialRooms(new ConnectSpecialRoom());
        builder.setUpdateRoomDescriptions(assembleOrdinaryDescriptor());
        builder.setUpdateSpecialRoomDescriptions(assembleSpecialDescriptor());
        return builder;
    }
}
