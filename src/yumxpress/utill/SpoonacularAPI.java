/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.utill;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;
import yumxpress.pojo.ProductPojo;

/**
 *
 * @author JASRAJ
 */
public class SpoonacularAPI {
   
      public static List<ProductPojo> getAllItemDetailsByName(String foodName)throws Exception{ 
         String apiKey = "65cf56d6a9b84b1580be176b1959275b"; 
         String apiUrl = " https://api.spoonacular.com/food/search?query=" + foodName + "&number=2&apiKey=" + apiKey; 
         List<ProductPojo> foodList=new ArrayList<ProductPojo>(); //???????
         HttpResponse<JsonNode> response = Unirest.get(apiUrl) 
                    .header("accept", "application/json") 
                    .asJson(); 
 
            JSONObject jsonResponse = response.getBody().getObject(); 
            JSONArray searchResultsArray = jsonResponse.getJSONArray("searchResults"); 
            //System.out.println("SearchResultsArray:"+searchResultsArray); 
            for (int i = 0; i < searchResultsArray.length(); i++) { 
                JSONObject searchResult = searchResultsArray.getJSONObject(i); 
                JSONArray resultsArray = searchResult.getJSONArray("results"); 
 
                for (int j = 0; j < resultsArray.length(); j++) { 
                    JSONObject result = resultsArray.getJSONObject(j); 
 
                    if (!result.has("name") || !result.has("image")) { 
                        continue; 
                    } 
                    String itemName = result.getString("name"); 
                    String imageUrl = result.getString("image"); 
                    String imageType = imageUrl.substring(imageUrl.lastIndexOf(".") + 1, imageUrl.length()); 
 
                    if (itemName.isEmpty() || imageUrl.isEmpty()) { 
                        continue; 
                    } 
 
                    HttpURLConnection url = (HttpURLConnection) new URL(imageUrl).openConnection(); 
                    url.addRequestProperty("user-agent", "mozilla"); 
 
                    if (url.getResponseCode() != HttpURLConnection.HTTP_OK) { 
                        continue; 
                    } 
 
                    Image image = ImageIO.read(url.getInputStream()); 
 
                    ProductPojo product=new ProductPojo(); 
                    product.setProductName(itemName); 
                    product.setProductImage(image); 
                    product.setProductImageType(imageType); 
                    foodList.add(product); 
 
                } 
            } 
        return foodList; 
    } 
    
    
}
