package com.engineerai.lib.helper;

public class ScumberException extends Exception
{
	@SuppressWarnings("unused")
	private final long serialVersionUID = 1L;

	public ScumberException()
	{
		super();
	}

	public ScumberException(final String message, final Throwable cause)
	{
		super(message, cause);
	}

	public ScumberException(final String message)
	{
		super(message);
	}

	public ScumberException(final Throwable cause)
	{
		super(cause);
	}
}
