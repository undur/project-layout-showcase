package wonderfluffy;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction {

	public DirectAction( WORequest request ) {
		super( request );
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName( wonderfluffy.components.Main.class.getName() );
	}
}
