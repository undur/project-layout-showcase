package plainwostandard;

import com.webobjects.appserver.WOApplication;

import er.extensions.projectlayout.ERXProjectLayout;

public class Application extends WOApplication {

	// Before main() touches NSBundle, which reads its bundle factories once: running from the project folder, this
	// project and its dependencies are found where build.properties says
	static {
		ERXProjectLayout.register();
	}

	public static void main( String[] argv ) {
		WOApplication.main( argv, Application.class );
	}

	public Application() {
		setDefaultRequestHandler( requestHandlerForKey( directActionRequestHandlerKey() ) );
	}
}
