package wonderstandard;

import er.extensions.appserver.ERXApplication;

import er.extensions.projectlayout.ERXProjectLayout;

public class Application extends ERXApplication {

	// Before main() touches NSBundle, which reads its bundle factories once: running from the project folder, this
	// project and its dependencies are found where build.properties says
	static {
		ERXProjectLayout.register();
	}

	public static void main( String[] argv ) {
		ERXApplication.main( argv, Application.class );
	}

	public Application() {
		setDefaultRequestHandler( requestHandlerForKey( directActionRequestHandlerKey() ) );
	}
}
