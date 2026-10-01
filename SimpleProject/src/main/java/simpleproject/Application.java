package simpleproject;

import er.extensions.appserver.ERXApplication;
import er.extensions.routes.RouteTable;

public class Application extends ERXApplication {

	public static void main( String[] args ) {
		ERXApplication.main( args, Application.class );
	}

	public Application() {
		RouteTable.defaultRouteTable().map( "/", Main.class );
	}
}
