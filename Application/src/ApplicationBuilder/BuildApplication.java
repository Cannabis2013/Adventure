package ApplicationBuilder;

import ApplicationBuilder.Application.Application;
import ApplicationBuilder.BuildMap.BuildMap;
import ApplicationBuilder.BuildMap.BuildRooms.BuildRooms;
import ApplicationBuilder.BuildMap.MapInitialization.Repositories.OrdinaryMapDescriptions;
import ApplicationBuilder.BuildMap.MapInitialization.Repositories.SpecialMapDescriptions;
import ApplicationBuilder.BuildMap.MapInitialization.UpdateRoomDescriptions;
import ApplicationBuilder.BuildMap.RoomConnector.ConnectRegularRooms;
import ApplicationBuilder.BuildMap.RoomConnector.ConnectSpecialRoom;
import ApplicationBuilder.MapLogistics.MapTraverseTo;

public class BuildApplication {
    BuildMap assembleMapBuilder(){
        var builder = new BuildMap();
        builder.setRoomBuilder(new BuildRooms());
        builder.setConnectRegularRooms(new ConnectRegularRooms());
        builder.setConnectSpecialRooms(new ConnectSpecialRoom());
        builder.setUpdateRoomDescriptor(new UpdateRoomDescriptions());
        builder.setOrdinaryMapDescriptions(new OrdinaryMapDescriptions());
        builder.setSpecialMapDescriptions(new SpecialMapDescriptions());
        return builder;
    }

    MapTraverseTo assembleMapTraverser(){
        var traverser = new MapTraverseTo();
        return traverser;
    }

    public Application build(){
        var app = new Application();
        app.setMapBuilder(assembleMapBuilder());
        app.setMapTraverser(assembleMapTraverser());
        app.init();
        return app;
    }
}
