package org.servicedx.util;

public interface EBusinessKey
{

	public enum EKey implements EnumInterface
	{
		Primary;

		public static String Auto(String code)
		{
			try
			{
				Thread.sleep(1);
				return Masker.generateMD5(code + System.currentTimeMillis());
			}
			catch (Exception excep)
			{
				return code + System.currentTimeMillis();
			}
		}

		public static String AutoUnMask(String code)
		{
			try
			{
				Thread.sleep(1);
				return code + System.currentTimeMillis();
			}
			catch (Exception excep)
			{
				return code + System.currentTimeMillis();
			}
		}

		public static String Auto(String... codes)
		{
			String business = "";
			try
			{
				for (String code : codes)
				{
					business += code;
				}
				return Masker.generateMD5(business);
			}
			catch (Exception e)
			{
				return business + System.currentTimeMillis();
			}
		}
	}

	public String getBusinessKey(String... combination);
}
