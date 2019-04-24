package com.engineerai.lib.helper;

import java.io.InputStream;
import java.net.URL;

public class ClassLoaderResourceLocator extends AbstractResourceLocator
{
	public ClassLoaderResourceLocator()
	{
		super();
	}

	public ClassLoaderResourceLocator(final String prefix)
	{
		super(prefix);
	}

	@Override
	public URL getAsUrl(final String resource)
	{
		final URL url = Thread.currentThread().getContextClassLoader().getResource(getResourceName(resource));
		return url;
	}

	@Override
	public InputStream getAsStream(final String resource)
	{
		final String resourceName = getResourceName(resource);
		final InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(
				resourceName);
		return stream;
	}
}
