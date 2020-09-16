/**
 * WeatherWebServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.client;

public class WeatherWebServiceTestCase extends junit.framework.TestCase {
    public WeatherWebServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testWeatherWebServiceSoapWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoapAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.client.WeatherWebServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1WeatherWebServiceSoapGetSupportCity() throws Exception {
        com.client.WeatherWebServiceSoap_BindingStub binding;
        try {
            binding = (com.client.WeatherWebServiceSoap_BindingStub)
                          new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String[] value = null;
        value = binding.getSupportCity(new java.lang.String());
        // TBD - validate results
    }

    public void test2WeatherWebServiceSoapGetSupportProvince() throws Exception {
        com.client.WeatherWebServiceSoap_BindingStub binding;
        try {
            binding = (com.client.WeatherWebServiceSoap_BindingStub)
                          new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String[] value = null;
        value = binding.getSupportProvince();
        // TBD - validate results
    }

    public void test3WeatherWebServiceSoapGetSupportDataSet() throws Exception {
        com.client.WeatherWebServiceSoap_BindingStub binding;
        try {
            binding = (com.client.WeatherWebServiceSoap_BindingStub)
                          new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.client.GetSupportDataSetResponseGetSupportDataSetResult value = null;
        value = binding.getSupportDataSet();
        // TBD - validate results
    }

    public void test4WeatherWebServiceSoapGetWeatherbyCityName() throws Exception {
        com.client.WeatherWebServiceSoap_BindingStub binding;
        try {
            binding = (com.client.WeatherWebServiceSoap_BindingStub)
                          new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String[] value = null;
        value = binding.getWeatherbyCityName(new java.lang.String());
        // TBD - validate results
    }

    public void test5WeatherWebServiceSoapGetWeatherbyCityNamePro() throws Exception {
        com.client.WeatherWebServiceSoap_BindingStub binding;
        try {
            binding = (com.client.WeatherWebServiceSoap_BindingStub)
                          new com.client.WeatherWebServiceLocator().getWeatherWebServiceSoap();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String[] value = null;
        value = binding.getWeatherbyCityNamePro(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

}
