package cn.com;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;

public class WetherTest {
    public static void main(String[] args) throws Exception{

        String encoding="UTF-8";
        //wsdl的地址
        String endpoint= "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        //命名空间
        String targetNamespace="http://WebXml.com.cn/";
        String soapActionURI="http://WebXml.com.cn/getWeatherbyCityName";
        //具体调用的方法名
        String method="getWeatherbyCityName";
        //调用接口的参数的名字
        String[] paramNames={"theCityName"};
        String[] paramValues={"58027"};
        Service service=new Service();
        Call call=(Call) service.createCall();
        call.setSOAPActionURI(soapActionURI);
        call.setTargetEndpointAddress(new URL(endpoint));
        call.setEncodingStyle(encoding);
        call.setOperationName(new QName(targetNamespace,method));
        call.setUseSOAPAction(true);
        call.addParameter(new QName(targetNamespace,paramNames[0]), XMLType.XSD_STRING, ParameterMode.IN);

        call.setReturnClass(String[].class);
        String[] result=(String[])call.invoke(new Object[]{paramValues[0]});
        System.out.println("result is " + result.toString());

        if(result !=null && result.length>0){
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
