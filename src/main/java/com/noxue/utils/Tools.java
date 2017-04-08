package com.noxue.utils;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by noxue on 2017/4/8.
 */
public class Tools {

    public static String getEditorHtml(String url) {
        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.AMERICA_NEWYORK).build());

        driver.get(url);
        String html = driver.getPageSource();

        Pattern pattern = Pattern.compile("<noxue.*?>([\\s\\S]*?)</noxue>");
        Matcher m = pattern.matcher(html);
        if(m.find()) {
            html = m.group(1);
        }

        driver.quit();
        return html;
    }
}
