package cn.com;


import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;

public class test {
    public static void main(String[] args) {
        try {
            String encoding="utf-8";
            //wsdl的地址
            String endpoint= "http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx?wsdl";
            //命名空间
            String targetNamespace="http://WebXml.com.cn/";
            //具体方法的调用uri.在wsdl中对应的标签。
            String soapActionURI="http://WebXml.com.cn/getCharFonts";
            //具体调用的方法名
            String method="getCharFonts";
            //调用接口的参数的名字
            String[] paramNames={"byFontsLength"};
            //调用接口的参数的值
            Integer[] paramValues={5};
            Service service= new Service();
            Call call=(Call) service.createCall();
            call.setSOAPActionURI(soapActionURI);
            call.setTargetEndpointAddress(new URL(endpoint));
            call.setEncodingStyle(encoding);
            call.setOperationName(new QName(targetNamespace,method));
            call.setUseSOAPAction(true);
            call.addParameter(new QName(targetNamespace,paramNames[0]), XMLType.XSD_INTEGER, ParameterMode.IN);
            call.setReturnClass(String[].class);
            String[] result=(String[])call.invoke(new Object[]{paramValues[0]});
            System.out.println("result is " + result.toString());

            if(result !=null && result.length>0){
                for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
