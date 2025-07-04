package org.example.service;

import org.example.model.Service;

public class ServiceFactory {
    public Service getService(String serviceType){
        if (serviceType == null) return null;
        switch(serviceType.toLowerCase()){
            case "xray":
                return new Xray();
            case "consultation":
                return new Consultation();
            case "surgery":
                return new Surgery();
            default:
                return null;




        }
    }
}
