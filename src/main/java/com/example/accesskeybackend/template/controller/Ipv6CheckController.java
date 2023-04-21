package com.example.accesskeybackend.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Ipv6CheckController {

    @GetMapping("/api/web/checkIpv6Support")
    public String checkIpv6Support(@RequestParam String siteUrl) {
        boolean success = checkSiteIpv6Support(siteUrl);
        if (success) {
            return "200";
        }
        else {
            return "404";
        }
    }
    private boolean checkSiteIpv6Support(String siteUrl) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(siteUrl);
            for (InetAddress address : addresses) {
                if (address instanceof Inet6Address) {
                    return true;
                }
            }
        } catch (UnknownHostException e) {
            // обработка ошибок
        }
        return false;
    }}
