package com.gre.todo.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.core.util.resource.UrlResourceStream;
import org.apache.wicket.core.util.resource.locator.ResourceStreamLocator;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.string.Strings;

/**
 * this piece of code i have taken from
 * http://www.mkyong.com/tutorials/wicket-tutorials/
 * Created by Jan_R on 08/05/2017.
 */
public class GreStreamLocator extends ResourceStreamLocator {

    @Override
    public IResourceStream locate(Class<?> clazz, String path) {
        String location;
        String extension = path.substring(path.lastIndexOf('.') + 1);
        String simpleFileName = Strings.lastPathComponent(clazz.getName(), '.');
        location = "/pages/" + simpleFileName + "." + extension;
        URL url;
        try {
            url = WebApplication.get().getServletContext().getResource(location);
            if (url != null) {
                return new UrlResourceStream(url);
            }
        } catch (MalformedURLException e) {
            throw new WicketRuntimeException(e);
        }

        return super.locate(clazz, path);
    }

}
