package day01;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboDemo {

    public static void main(String[] args) {


        ExtensionLoader<SPID> extensionLoader =
                ExtensionLoader.getExtensionLoader(SPID.class);

        SPID optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.say();
        SPID bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.say();


    }
}
