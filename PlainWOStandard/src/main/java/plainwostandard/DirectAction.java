package plainwostandard;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WODirectAction;

public class DirectAction extends WODirectAction {

	public DirectAction( WORequest request ) {
		super( request );
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName( plainwostandard.components.Main.class.getName() );
	}
}
