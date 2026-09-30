package sun.security.action;

import java.security.PrivilegedAction;

/**
 * Replaces a class the JDK removed in JDK 24 along with the Security Manager. WebObjects' NSTimeZone still uses it, so
 * without it an application fails at startup on JDK 24 and later. wonder-slim's ERExtensions includes the same class.
 */
public class GetPropertyAction implements PrivilegedAction<String> {

	private final String _propertyName;

	public GetPropertyAction( String propertyName ) {
		_propertyName = propertyName;
	}

	@Override
	public String run() {
		return System.getProperty( _propertyName );
	}
}
