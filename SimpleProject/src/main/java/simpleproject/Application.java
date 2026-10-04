package simpleproject;

import er.extensions.appserver.ERXApplication;
import er.extensions.routing.ERXRouter;

public class Application extends ERXApplication {

	public static void main( String[] args ) {
		ERXApplication.main( args, Application.class );
	}

	public Application() {
		ERXRouter.declare( routes -> routes.map( "/", Main.class ) );
	}
}
