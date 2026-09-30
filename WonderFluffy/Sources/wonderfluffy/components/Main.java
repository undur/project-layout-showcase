package wonderfluffy.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSBundle;
import er.extensions.components.ERXComponent;

/**
 * Shows that the application found its three kinds of resources: this page (the components folder), a value from its
 * Properties (the WebObjects resources folder) and a stylesheet (the web server resources folder)
 */
public class Main extends ERXComponent {

	public int counter;

	public Main( WOContext context ) {
		super( context );
	}

	/**
	 * @return The class of the bundle NSBundle found for this application
	 */
	public String bundleClass() {
		return NSBundle.mainBundle().getClass().getName();
	}

	/**
	 * @return A value from the application's Properties
	 */
	public String greeting() {
		return System.getProperty( "showcase.greeting", "NOT FOUND: the Properties file wasn't loaded" );
	}

	/**
	 * @return The URL of the stylesheet among the web server resources
	 */
	public String cssURL() {
		return application().resourceManager().urlForResourceNamed( "showcase.css", null, null, context().request() );
	}

	/**
	 * A component action, to show the page is restored from the session
	 */
	public WOActionResults bump() {
		counter++;
		return null;
	}
}
