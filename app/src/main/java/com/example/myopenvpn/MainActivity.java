package com.example.myopenvpn;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import de.blinkt.openvpn.base.OpenVpnActivity;

import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class MainActivity extends OpenVpnActivity implements OpenVpnActivity.VPNStatusListener{
    private static final String TAG = "OPENVPNCONNECTSTATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //安徽220.179.102.10黄山xmdlgjqk:xmdlfiyw
        startOpenVpns("220.179.102.10","xmdlgjqk","xmdlfiyw");
    }
    private void startOpenVpns(String mStrIp, String mStrAccount, String mStrPassWord) {
        StringBuilder sb = new StringBuilder();
        String s = sb.append("client\n" +
                "dev tun\n" +
                "proto tcp\n" + "remote " + mStrIp).append(" 8194\n" + "nobind\n" +
                "persist-key\n" +
                "persist-tun\n" +
                "tls-client\n" +
                "remote-cert-tls server\n" +
                "verb 4\n" +
                "mute 10\n" +
                "cipher AES-256-CBC\n" +
                "auth SHA1\n" +
                "auth-user-pass\n" +
                "auth-nocache\n" +
                "redirect-gateway\n" +
                "<ca>\n" +
                "-----BEGIN CERTIFICATE-----\n" +
                "MIIDKjCCAhKgAwIBAgIIAVYmpXO42x0wDQYJKoZIhvcNAQELBQAwIDEeMBwGA1UE\n" +
                "AwwVcm9zLW92cG4tdnBuLWR0b3BzLmNjMB4XDTIxMDQwODE0MjAxMVoXDTMxMDQw\n" +
                "NjE0MjAxMVowIDEeMBwGA1UEAwwVcm9zLW92cG4tdnBuLWR0b3BzLmNjMIIBIjAN\n" +
                "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA19x1txbfJT5YOcPvYYsVU3ZliJ0u\n" +
                "ncvlVAaEV/NsPYBi3wzPNr8WQvR5NF8KaCdk+o+n1agErI9EdTRohgrVNvTmCEzT\n" +
                "LqqRaE52cff+emONxbhjRBQ0aszlxZAS1ibB+a+YLHgH6ePjpUh0JbeFg14SQtq3\n" +
                "aY4vCfuHIQFVejLucQ3KQ/1lPn9cUAuWvZuCtdjvut1hrvfdfh3nfBJRFp4s9Va4\n" +
                "foniWx6SfBmIvZ97ATSCjcD8jc2xBwdishZEMlfqKuLU1YHDbRLt3MGmMzL69nx2\n" +
                "XvtBVggYD7DTIrCrpW58tkmMzUtLhNb0KvPELPrx6AJW5FHhbl1azOq2LQIDAQAB\n" +
                "o2gwZjAPBgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBBjAdBgNVHQ4EFgQU\n" +
                "59EMoTWW/57WPLuYI7Fx+n9FJv0wJAYJYIZIAYb4QgENBBcWFUdlbmVyYXRlZCBi\n" +
                "eSBSb3V0ZXJPUzANBgkqhkiG9w0BAQsFAAOCAQEAxSEDzqi8hMO1lb2HolTOuSKD\n" +
                "3ZUhxIs20lg/IAqI0CupQ2CIaV86CasSJBMIMaQ1DcLGwqefqIn4SD3uKkPfoRDL\n" +
                "IkyeOdtmH0cpxGUzLHXxaYVWuP/kv7/pd9zX90+5ag4u34NQZiegoQGe9WIHi/Rz\n" +
                "g/qVNIAim+GeusxiSi30LKN+uQZ2Pf+ofMVQjJowwwnQJg19AZQSoxl4Ycv/F+r3\n" +
                "ClT8NkL0mzOOGYwt1u7iuJMXEZvqK0VypMgKABwLhEHkjT8QLnHtpn1APdDYf7mA\n" +
                "MwG0+VzThpP31EZHXntSBhcwuLNitgwy5RECuOWPi5PA266qfAhbXB9iZwazAQ==\n" +
                "-----END CERTIFICATE-----\n" +
                "\n" +
                "</ca>\n" +
                "\n" +
                "<cert>\n" +
                "-----BEGIN CERTIFICATE-----\n" +
                "MIIDRjCCAi6gAwIBAgIIAbCukkrSPdwwDQYJKoZIhvcNAQELBQAwIDEeMBwGA1UE\n" +
                "AwwVcm9zLW92cG4tdnBuLWR0b3BzLmNjMB4XDTIxMDQwODE0MjAxNloXDTMxMDQw\n" +
                "NjE0MjAxNlowJzElMCMGA1UEAwwcY2xpZW50LnJvcy1vdnBuLXZwbi1kdG9wcy5j\n" +
                "YzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAOPog8Tzf4EOQn4rzBsF\n" +
                "Qkhnlz8Pyd4veR1RkrBmX3Si4ixL7BMo+usuag1s6lTtksazuomCBnFrVv4Hg9Tm\n" +
                "lHLfEEtgXZRFfmOWv3bcpGudekRbijlBAAHkQJ9KrbJJ6K4LEg7cOPIiPpOLSR8s\n" +
                "rBXxO3j+k1PwhOdNEWf40asUmQr38AUC8FeXV2Ge7ZpWe89V0WxygdFJfnqAsIyE\n" +
                "RpScdYeZSR6VwdcG3R6QFrrBHPm516hz2vJIi9H0mRmooB4g0a7/akglfF5HTU5O\n" +
                "8oKrP3ZeKasx6Z7icudjFIU5XFM/wCfAZuWJrEA/6hO++DAVaqviuyBUb3gOQIge\n" +
                "/G0CAwEAAaN9MHswEwYDVR0lBAwwCgYIKwYBBQUHAwIwHQYDVR0OBBYEFHYvjCWd\n" +
                "mwj9EZgG+4dZ5aIsSPApMB8GA1UdIwQYMBaAFOfRDKE1lv+e1jy7mCOxcfp/RSb9\n" +
                "MCQGCWCGSAGG+EIBDQQXFhVHZW5lcmF0ZWQgYnkgUm91dGVyT1MwDQYJKoZIhvcN\n" +
                "AQELBQADggEBADpA1828EgSJK1t15UNewuyaxg+UssP8vjPjOgodIMBx5m0QHksH\n" +
                "doxPB8iSeLnCa2aGViHlflrzXOiLkfGPjG9TgAnLfGWO+tWgZXnKL283Io3CsKTC\n" +
                "ZYFAFCqKCEkEJRB2c3ua3ZAK+KhFE7FJxmcCt1D7OQ7PdSZ3n7VVcexo/XS89fej\n" +
                "o5YejR3VkTSzYpC7Qdqz8RoL7ORQtoAwBh7Eo7gRc7r0p3117WfPlH+biYnba/ja\n" +
                "0JG39VTf9q+7p/u5e4PhkHUQ2LaPDDKPlDCI6WC9ywMjKhfbYnbrcpKKmApSNrl2\n" +
                "UCyhFNDpcAWmXDrO6vxqbcmyNAWYz5eZOsM=\n" +
                "-----END CERTIFICATE-----\n" +
                "\n" +
                "</cert>\n" +
                "\n" +
                "<key>\n" +
                "-----BEGIN ENCRYPTED PRIVATE KEY-----\n" +
                "MIIFHzBJBgkqhkiG9w0BBQ0wPDAbBgkqhkiG9w0BBQwwDgQIzB0+gJPaYwMCAggA\n" +
                "MB0GCWCGSAFlAwQBKgQQeAKCXPmlxrl4TD9PuCjmvQSCBNCr3sScxYyg4q98I2AG\n" +
                "0uQPztyQtDT6W7f8Y5araIxnqpNi5UNzKziCeBzsY4liaiyYQVHJbY3Fj+PF1pjM\n" +
                "M/ZjlXrYdeKvEW2nAAXWdRhXMPx/XALCL3gmKJtOuhFaZ0rgzgKk/kK14N4w+x5F\n" +
                "GYSMEUEFSuJaTQCklQ51NnJQDKP+yNbDqok28c27GNqiGl/cJj1hSvr/9uVo1CZj\n" +
                "fJsj3JGStPduk6B7zsfOzvrcQB2J58rnq6L5V3QR+UIqvXqks/fzcMzAES0VJ9/O\n" +
                "8zDfX5P0WObTUEtoTIbNRo4f0MAaRZofDvu4G9AC3ZVQsw8qNb+v68Vclp+7Tctf\n" +
                "wnKQw4wXnRQvbNGqaicJvoWgSLsGHNkV4EW19jBKdFvJRmsh70slyQk5retRX8Dk\n" +
                "GP1eJggcUsvQ982zqv/1p++qG2mXpVior2LVLt1piF9rtezAktRhb6P/9kuJXOu/\n" +
                "io/SHrvutPWjtY5gt366kqqLsulObAZDYY3LIkvqoYi71nxk+rftD5R4jtB0kFRy\n" +
                "Fvw7W0yaaRzUpANl5iSd2+YaVRTfunxR+kkQybPmwST0BrPwvRL/MTSzWdBd6roR\n" +
                "sL3Co2kKtb/RoKAWF8smmpvLa3nGZhNzUrXF3wj8AbkalSDiAsQBt3HtB3wezL+n\n" +
                "xDiI34n8IEI2nP0S9bEvv2BQY3RpOQM0CGZOBVRQA3VcQdWRVqBK/yUf0YVrcc1Z\n" +
                "m7drmpjeKQJ3NofzZEBYq8aHPeJGa0MBNoJbYDY0+IHYf7NgMJQukN9WJkgEwIyA\n" +
                "DtYeVAKJRKq7egEuWDgtrfr9NYMtXiHIzCiOStp00INyNdX8+PllEnFnCciPDdLk\n" +
                "2IBtfCjjVF2IeowispO8VlamMdRVMG1b1QpDBWsbzyvPq1yCNJ9bTtScu8ABtILD\n" +
                "ZGQMTSzO72R5IY+bXP2T8WDTCqjZZKnpphP8/cbiY0+8mbQkZ8Pz/v5Y4cdpu9Ro\n" +
                "/ckVW8M1TF2ch30giZXmk3Gd9UVxL6cnCYIaZjHDofyMj5smQ5mdJF1i+DbuYvm2\n" +
                "Ll55czJOXRjRzV5YPb6yTcfbBTQT/JkT2n3ZRKktiG0aFESDnjIdoGOOZwXUJMJG\n" +
                "sou5hWAO61uBKaVGr+y2zZM9J+6Qu7e1quOGZuUsLkYv2Af2n083SndKP8/9Xpfg\n" +
                "I86tZRtJGGptnULBUQD21Mg5o3d2l2wVqBYvOZHpq0+QhxBxGAHkA2aIJ34P9GiT\n" +
                "a5NwpcsRTokNzwov4UJ5tZR/1CuCojL1N1WbpfVFEVg+Dyyp7jmKxIXRz4BkRg+c\n" +
                "I4ksSXjdcOJqrgqxgpQSXeTdkfVsV0F4LwPOWWHxOtMZM9foJnbsYfN2viVw1G45\n" +
                "K67Z+pkPEfC4BQtjzos1/2OiK/ixDnqAe4DLN2MZpzJFZNRMWsjf/vBeHwT/U8Fw\n" +
                "Wabgcli4AO6OyKmvAq6/6qQfijvfEckqzdtNkAxdTA4ZSksTO2d2BIY0oaNyvGew\n" +
                "v+203k5q6ngYFZMEfbCFo5U/rUH8PJm7l+Jlw8qZTHP7gguXcrE50YWzaW4dil6c\n" +
                "p6v0K+2UNLr+RSB1jdOBlavyXfCH0LnjeMe8egwyr4mDj/x55phfkQfupBnxxVK3\n" +
                "NwtEWrITPuYdcPlT8g6BFT8Ceg==\n" +
                "-----END ENCRYPTED PRIVATE KEY-----\n" +
                "\n" +
                "</key>").toString();

        loadVpnProfile(s);
        //set name
        getVpnProfile().mName = getString(R.string.app_name);
        //set OpenVpn password
        getVpnProfile().mKeyPassword = "xmdl8888";
        //set account and password
        setAccountAndPassword(mStrAccount, mStrPassWord);
        connectVpn();
    }

    @Override
    public Intent getJumpIntent() {
        Intent intent = new Intent();
        intent.setClassName(getPackageName(), MainActivity.class.getName());
        intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP);
        return intent;
    }


    @Override
    public void onConnectStart() {
        Log.e(TAG,"onConnectStart");
    }

    @Override
    public void onConnected() {
        Log.e(TAG,"onConnected");
    }

    @Override
    public void onPaused() {
        Log.e(TAG,"onPaused");
    }

    @Override
    public void onServerReplied() {
        Log.e(TAG,"onServerReplied");
    }

    @Override
    public void onServerNoReplied() {
        Log.e(TAG,"onServerNoReplied");
    }

    @Override
    public void onNoNetwork() {
        Log.e(TAG,"onNoNetwork");
    }

    @Override
    public void onConnectClose() {
        Log.e(TAG,"onConnectClose");
    }

    @Override
    public void onAuthFailed() {
        Log.e(TAG,"onAuthFailed");
    }

    @Override
    public void onUnknown() {
        Log.e(TAG,"onUnknown");
    }
}