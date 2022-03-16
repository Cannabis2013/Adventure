package ApplicationBuilder;

import ApplicationBuilder.Application.Application;
import ApplicationBuilder.AssembleMapBuilder.AssembleMapBuilder;
import ApplicationBuilder.AssembleMapLogistics.AssembleMapTraverser;

public class BuildApplication {
    AssembleMapBuilder _assembleMapBuilder = new AssembleMapBuilder();
    AssembleMapTraverser _assembleMapTraverser = new AssembleMapTraverser();

    public Application build(){
        var app = new Application();
        app.setMapBuilder(_assembleMapBuilder.assemble());
        app.setMapTraverser(_assembleMapTraverser.assemble());
        app.init();
        return app;
    }
}
