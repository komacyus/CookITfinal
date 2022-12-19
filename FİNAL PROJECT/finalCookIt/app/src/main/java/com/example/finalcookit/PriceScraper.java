package com.example.finalcookit;
/**
 * implementation 'org.jsoup:jsoup:1.15.3'
 * JSoup has to be implemented to build.gradle for this class to work properly
 *
 *  manifests kısmına eklencek:
 * <uses-permission android:name="android.permission.INTERNET"/>
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PriceScraper {

    private String name;
    private String amount;
    private String price;
    private String URL;
    private Document doc;

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public PriceScraper(String url) throws IOException {
        doc = Jsoup.connect(url).get();
        this.URL = url;
        this.name = getNameFromURL();
        this.price = getPriceFromURL();
        this.amount = getAmountFromURL();
    }

    /**
     * @return the name of the ingredient at the statet groccery shopping link
     */
    public String getNameFromURL(){
        return doc.title();
    }

    /**
     * @return the price of the ingredient at the statet groccery shopping link for the amount
     */
    public String getPriceFromURL(){
        return doc.select("div.sc-dd9e2587-7 > span").last().text();
    }

    /**
     * @return the amount of the ingredient at the statet groccery shopping link for the price
     */
    public String getAmountFromURL() {
        String amount = doc.select("div.sc-dd9e2587-2 > span").text();

        if (amount.contains("kg")) {
            return amount.replaceAll("\\D", "");
        }
        else if (amount.contains("g")){
            double amountTrimmed = Integer.parseInt(amount.replaceAll("\\D", ""));
            double value = amountTrimmed / 1000;
            String s = String.valueOf(value);
            return s;
        }

        else if(amount.contains("L")){
            return amount.replaceAll("\\D", "");
        }

        else if(amount.contains("ml")){
            double amountTrimmed = Integer.parseInt(amount.replaceAll("\\D", ""));
            double value = amountTrimmed / 1000;
            String s = String.valueOf(value);
            return s;
        }

        else{
            return amount.replaceAll("\\D", "");
        }



    }
}












