package cn.com.test;

import cn.com.WebXml.WeatherWebServiceSoapProxy;

import java.rmi.RemoteException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws RemoteException {
        WeatherWebServiceSoapProxy w = new WeatherWebServiceSoapProxy();
//        String s=w.getEndpoint();
//        System.out.println(s);
        String[] ss = w.getWeatherbyCityName("58027");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
}
