package com.enonic.xp.sample.xmlparser;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.json.XML;
import org.junit.Test;

import com.google.common.io.ByteStreams;

import com.enonic.xp.script.serializer.JsonMapGenerator;

public class XmlMapperTest
{

    @Test
    public void testName()
        throws Exception
    {
        final JSONObject jsonObject = XML.toJSONObject( getFile( "cars.xml" ) );

        final JsonMapGenerator gen = new JsonMapGenerator();
        new XmlMapper( jsonObject ).serialize( gen );

        final String s = gen.getRoot().toString();
        System.out.println( s );
    }


    private String getFile( final String fileName )
        throws Exception
    {
        try (final InputStream resourceAsStream = XmlMapperTest.class.getResourceAsStream( fileName ))
        {
            return new String( ByteStreams.toByteArray( resourceAsStream ), StandardCharsets.UTF_8 );
        }
    }
}