package org.servicedx.security.resource;

import org.servicedx.security.resource.IPath.ERole;
import org.servicedx.util.EnumInterface;

public interface EnumResourceInterface extends EnumInterface
{
	public String getPath();

	public ERole[] getRoles();

}
