/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.utill;

/**
 *
 * @author JASRAJ
 */
public class OwnerProfile {

    public static String getOwnerName() {
        return OwnerName;
    }

    public static void setOwnerName(String OwnerName) {
        OwnerProfile.OwnerName = OwnerName;
    }

    public static String getCompanyName() {
        return CompanyName;
    }

    public static void setCompanyName(String CompanyName) {
        OwnerProfile.CompanyName = CompanyName;
    }

    public static String getCompanyId() {
        return CompanyId;
    }

    public static void setCompanyId(String CompanyId) {
        OwnerProfile.CompanyId = CompanyId;
    }
    private static  String OwnerName;
    private static String CompanyName;
    private static String CompanyId;
    
    
}
