package eel.kitchen.jsonschema.validators.format;

import eel.kitchen.jsonschema.JasonLoader;
import eel.kitchen.jsonschema.validators.Validator;
import org.codehaus.jackson.JsonNode;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FormatValidatorTest
{
    private JsonNode inputs, node;
    private Validator v;

    @BeforeClass
    public void setUp()
        throws IOException
    {
        inputs = JasonLoader.load("format.json");
    }

    @Test
    public void testDateTime()
    {
        node = inputs.get("date-time");
        v = new ISO8601DateFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testDate()
    {
        node = inputs.get("date");
        v = new DateFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testTime()
    {
        node = inputs.get("time");
        v = new TimeFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testUTCMilliSec()
    {
        node = inputs.get("utc-millisec");
        v = new UnixEpochFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testRegex()
    {
        node = inputs.get("regex");
        v = new RegexFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testCSSColor()
    {
        node = inputs.get("color");
        v = new CSSColorValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testCSSStyle()
    {
        node = inputs.get("style");
        v = new CSSStyleValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testPhoneNumber()
    {
        node = inputs.get("phone");
        v = new PhoneNumberFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testURI()
    {
        node = inputs.get("uri");
        v = new URIFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testEmail()
    {
        node = inputs.get("email");
        v = new EmailFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testIPv4()
    {
        node = inputs.get("ip-address");
        v = new IPv4FormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testIPv6()
    {
        node = inputs.get("ipv6");
        v = new IPv6FormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }

    @Test
    public void testHostName()
    {
        node = inputs.get("hostname");
        v = new HostnameFormatValidator();

        assertFalse(v.validate(node.get("bad")));
        assertTrue(v.validate(node.get("good")));
        assertTrue(v.getValidationErrors().isEmpty());
    }
}


