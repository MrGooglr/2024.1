package com.aniket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class App 
{
        public static void main(String[] args) {
            try {
                InetAddress inetAddress = InetAddress.getLocalHost();
                System.out.println(inetAddress.getCanonicalHostName());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
