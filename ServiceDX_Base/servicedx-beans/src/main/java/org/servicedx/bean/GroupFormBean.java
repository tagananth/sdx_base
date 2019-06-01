package org.servicedx.bean;

import org.servicedx.bean.model.Group;
import org.springframework.security.core.Authentication;

public class GroupFormBean extends APIStatus
{

	private static final long	serialVersionUID	= -5941251942253619396L;
	public Group				group;
	public Group				repoGroup;
	public long[]				groupIds;

	public void updateRepoGroup(Authentication auth)
	{
		repoGroup.setActive(group.isActive());
		repoGroup.setComments(group.getComments());
		repoGroup.setGroupName(group.getGroupName());
		repoGroup.modifiedUserInfo(auth);
	}
}
