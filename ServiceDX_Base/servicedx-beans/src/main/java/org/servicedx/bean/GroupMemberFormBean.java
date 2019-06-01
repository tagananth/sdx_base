package org.servicedx.bean;

import java.util.ArrayList;
import java.util.List;

import org.servicedx.bean.model.GroupMember;

public class GroupMemberFormBean extends APIStatus
{

	private static final long	serialVersionUID	= -1079851096651516709L;

	public GroupMember			groupMember			= new GroupMember();
	public GroupMember			repoGroupMember		= new GroupMember();
	public List<GroupMember>	groupMemberList		= new ArrayList<GroupMember>();
	public List<GroupUserBean>	groupUserList		= new ArrayList<GroupUserBean>();
	public String				groupId;
	public String				groupName;
	public String				groupMemberId;

}
