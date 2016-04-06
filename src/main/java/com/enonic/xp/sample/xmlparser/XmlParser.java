package com.enonic.xp.sample.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.json.XML;

import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;

public class XmlParser
{
    @SuppressWarnings("unused")
    public Object parse( final ByteSource byteSource )
        throws Exception
    {
        final JSONObject jsonObject = XML.toJSONObject( getAsString( byteSource ) );

        return new XmlMapper( jsonObject );
    }

    private String getAsString( final ByteSource byteSource )
        throws IOException
    {
        try (InputStream in = byteSource.openStream())
        {
            return new String( ByteStreams.toByteArray( in ), StandardCharsets.UTF_8 );
        }
        catch ( IOException e )
        {
            throw new RuntimeException( "Cannot read stream", e );
        }


    }
}
