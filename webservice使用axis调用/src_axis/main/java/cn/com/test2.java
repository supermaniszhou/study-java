package cn.com;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.StringUtils;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class test2 {
    public static void main(String[] args) {
        String url = "http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx?wsdl";
        String method = "getCharFonts";
        String targetNamespace="http://WebXml.com.cn/";
        String[] paramNames={"byFontsLength"};
        //调用接口的参数的值
        Integer[] paramValues={5};
        String result = null;
        Call rpcCall = null;
        try {
            //实例websevice调用实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);
            rpcCall.setOperationName(new QName(targetNamespace,method));
            rpcCall.addParameter(String.valueOf(paramNames), XMLType.XSD_INTEGER, ParameterMode.IN);
            rpcCall.setReturnClass(String[].class);
            //执行webservice方法
            result = (String) rpcCall.invoke(new Object[]{paramValues[0]});
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
