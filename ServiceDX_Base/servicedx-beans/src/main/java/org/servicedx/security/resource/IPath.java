package org.servicedx.security.resource;

import java.util.Map;

import org.servicedx.util.CommonValidator;
import org.servicedx.util.EnumInterface;
import org.servicedx.util.IConstProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public interface IPath extends IConstProperty
{
	public static final String	USER_FULL_NAME	= "userFullName";
	public static final String	CUSTOMER_NAME	= "customerName";
	public static final String	CUSTOMER_ID		= "customerId";
	public static final String	USER_ID			= "userId";
	public static final String	EMAIL			= "Email";
	public static final String	SMS				= "SMS";

	public enum EAuth implements EnumInterface
	{
		User;

		Map<String, Object> details = null;

		@SuppressWarnings("unchecked")
		void init(Authentication auth)
		{
			OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();
			this.details = (Map<String, Object>) oauthDetails.getDecodedDetails();
		}

		public String getFullName(Authentication auth)
		{
			if (details == null)
				init(auth);
			return (String) details.get(USER_FULL_NAME);
		}

		public String getCustomerName(Authentication auth)
		{
			if (details == null)
				init(auth);
			return (String) details.get(CUSTOMER_NAME);
		}

		public long getCustomerId(Authentication auth)
		{
			if (details == null)
				init(auth);

			if (CommonValidator.isNullOrEmpty(details.get(CUSTOMER_ID)))
				return 0L;
			return ((Integer) details.get(CUSTOMER_ID)).longValue();
		}

		public long getUserId(Authentication auth)
		{
			if (details == null)
				init(auth);
			return ((Integer) details.get(USER_ID)).longValue();
		}

		public boolean isSuperAdmin(Authentication auth)
		{
			if (details == null)
				init(auth);
			if (CommonValidator.isEqual((String) details.get(USER_FULL_NAME), ERole.SuperAdmin))
				return true;

			return false;
		}

		public boolean isAdministrator(Authentication auth)
		{
			for (GrantedAuthority _GA : auth.getAuthorities())
			{
				if (CommonValidator.isEqual(_GA.getAuthority(), ERole.Administrator))
					return true;
			}
			return false;
		}

	}

	public enum EMedia implements EnumInterface
	{
		Email, SMS
	}

	public enum EMediaType implements EnumInterface
	{
		All, Primary, Secondary
	}

	public enum ERole implements EnumInterface
	{
		SuperAdmin, Administrator, Supervisor, User
	}

	public enum ETemplate implements EnumInterface
	{
		User_Create_Admin, Test_Connection, User_Create_Employee, User_Token, User_Password, User_Reset_Password, User_Primary_Media_Update, SMS_Create_Employee, SMS_OTP;
	}

	public enum EReturn implements EnumInterface
	{
		Success, Failure, Exists, Not_Exists
	}

	public enum EFormAction implements EnumInterface
	{
		Add, Update, Search, SoftDelete, PermanentDelete, ChangePassword, ForgotPassword, Verify, PasswordChanged, TokenExpired
	}

	public enum ETopicPartition implements EnumInterface
	{
		Email, SMS, Message;
	}

	public enum EMessageStatus implements EnumInterface
	{
		New, Open, Completed, Error, Queued, Acknowledged, NotAcknowledged, Hold, OffDuty
	}
	
	//https://archive.clickatell.com/developers/api-docs/message-status-codes/
	public enum ESMSStatusCode implements EnumInterface
	{
		RECEIVED_BY_RECIPIENT
	}

	public enum EEntity implements EnumInterface
	{
		User, Group
	}

	public enum EScheduleType implements EnumInterface
	{
		Daily, Weekdays, Customize, Vacation
	}	

	public enum EScheduleColor implements EnumInterface
	{
		Blue, Green, Yellow, Red
	}
	
	public String	SOM_APPLICATION				= "SOMApplication";
	public String	HAS_AUTHORITY_SUPERADMIN	= "hasAuthority('SUPERADMIN')";
	public String	HAS_AUTHORITY_ADMINISTRATOR	= "hasAuthority('ADMINISTRATOR')";
	public String	HAS_AUTHORITY_SUPERVISOR	= "hasAuthority('SUPERVISOR')";
	public String	HAS_AUTHORITY_USER			= "hasAuthority('USER')";
	public String	HAS_AUTHORITY_BOTH			= HAS_AUTHORITY_ADMINISTRATOR + " or " + HAS_AUTHORITY_SUPERVISOR;
	public String	HAS_ALL_AUTHORITY			= HAS_AUTHORITY_ADMINISTRATOR + " or " + HAS_AUTHORITY_SUPERVISOR + " or " + HAS_AUTHORITY_USER;

	public String	INTERNAL_TOPIC				= "internal-topic";
	public String	MESSAGES_TOPIC				= "messages-topic";

}
